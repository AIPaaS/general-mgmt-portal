package com.ai.slp.common.cache;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.sdk.cache.base.AbstractCache;
import com.ai.slp.common.dao.mapper.bo.GnArea;
import com.ai.slp.common.service.atom.area.IGnAreaAtomService;

@Component
public class GnAreaCache extends AbstractCache {
    private static final Logger logger = LoggerFactory.getLogger(GnAreaCache.class);

    @Autowired
    private IGnAreaAtomService iGnAreaAtomService;
    
    
    private static final int PAGE_SIZE = 2000;
    @Override
    public void write() throws Exception {

        int totalSize = iGnAreaAtomService.getAreaCount();
       
        int totalPages = (totalSize + PAGE_SIZE - 1) / PAGE_SIZE;
        ExecutorService pool=null;
        try{
       
        //ExecutorService pool = Executors.newFixedThreadPool(threadCount);
        pool = Executors.newCachedThreadPool();
       // ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_GN_AREA);
        for (int i = 0; i < totalPages; i++){
            List<GnArea> resultList=iGnAreaAtomService.getAreaList(PAGE_SIZE*i, PAGE_SIZE);
            Thread t =new GnAreaCacheTread(resultList);
            pool.execute(t);    
        }
        }catch(Exception e){
           logger.info(e.getMessage(),e); 
        }finally{
            if(pool!=null){
                pool.shutdown(); 
            }
            
        }
          
        //pool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);   
       
     
    }

}
