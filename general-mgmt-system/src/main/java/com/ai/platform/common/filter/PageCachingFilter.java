/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.common.filter;

import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ai.platform.common.utils.DateUtils;
import com.ai.platform.common.utils.SpringContextHolder;
import com.ai.platform.common.utils.StringUtils;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.constructs.blocking.LockTimeoutException;
import net.sf.ehcache.constructs.web.AlreadyCommittedException;
import net.sf.ehcache.constructs.web.AlreadyGzippedException;
import net.sf.ehcache.constructs.web.filter.FilterNonReentrantException;
import net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter;

/**
 * 页面高速缓存过滤器
 * @author ThinkGem
 * @version 2013-8-5
 */
public class PageCachingFilter extends SimplePageCachingFilter {

	
	private final static Logger log = Logger.getLogger(PageCachingFilter.class);
	private CacheManager cacheManager = SpringContextHolder.getBean(CacheManager.class);
	
	@Override
	protected CacheManager getCacheManager() {
		this.cacheName = "pageCachingFilter";
		return cacheManager;
	}


    private final static String FILTER_URL_PATTERNS = "patterns";

    private static String[] cacheURLs;

    

    private void init() throws CacheException {

        String patterns = filterConfig.getInitParameter(FILTER_URL_PATTERNS);

        cacheURLs = StringUtils.split(patterns, ",");

    }

    

    @Override

    protected void doFilter(final HttpServletRequest request,

            final HttpServletResponse response, final FilterChain chain)

            throws AlreadyGzippedException, AlreadyCommittedException,

            FilterNonReentrantException, LockTimeoutException, Exception {

        if (cacheURLs == null) {

            init();

        }

        

        String url = request.getRequestURI();

        boolean flag = false;

        if (cacheURLs != null && cacheURLs.length > 0) {

            for (String cacheURL : cacheURLs) {

                if (url.contains(cacheURL.trim())) {

                    flag = true;

                    break;

                }

            }

        }

        // 如果包含我们要缓存的url 就缓存该页面，否则执行正常的页面转向

        if (flag) {

            String query = request.getQueryString();

            if (query != null) {

                query = "?" + query;

            }

            log.info("当前请求被缓存：" + url + query);
System.out.println("当前请求被缓存：" + url + query);
            super.doFilter(request, response, chain);

        } else {

            chain.doFilter(request, response);

        }
        System.out.println("当前请求被缓存："+DateUtils.getDateTime());
    }

    

    @SuppressWarnings("unchecked")

    private boolean headerContains(final HttpServletRequest request, final String header, final String value) {

        logRequestHeaders(request);

        final Enumeration accepted = request.getHeaders(header);

        while (accepted.hasMoreElements()) {

            final String headerValue = (String) accepted.nextElement();

            if (headerValue.indexOf(value) != -1) {

                return true;

            }

        }

        return false;

    }

    

    /**

     * @see net.sf.ehcache.constructs.web.filter.Filter#acceptsGzipEncoding(javax.servlet.http.HttpServletRequest)

     * <b>function:</b> 兼容ie6/7 gzip压缩

     * @author hoojo

     * @createDate 2012-7-4 上午11:07:11

     */

  /*  @Override

    protected boolean acceptsGzipEncoding(HttpServletRequest request) {

        boolean ie6 = headerContains(request, "User-Agent", "MSIE 6.0");

        boolean ie7 = headerContains(request, "User-Agent", "MSIE 7.0");

        return acceptsEncoding(request, "gzip") || ie6 || ie7;

    }*/
}
