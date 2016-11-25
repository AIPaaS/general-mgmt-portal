package com.ai.platform.modules.sys.realm;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.opt.sdk.components.mcs.MCSClientFactory;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;
import com.ai.paas.ipaas.util.SerializeUtil;
import com.ai.platform.common.config.Global;
import com.ai.platform.common.utils.JedisUtils;
import com.ai.platform.common.utils.SpringContextHolder;
import com.ai.platform.modules.sys.dao.RoleDao;
import com.ai.platform.modules.sys.entity.Menu;
import com.ai.platform.modules.sys.entity.Role;
import com.ai.platform.modules.sys.entity.User;
import com.ai.platform.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.ai.platform.modules.sys.service.SystemService;
import com.ai.platform.modules.sys.utils.UserUtils;

public class UserCasRealm  extends CasRealm{
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private SystemService systemService;
	@Autowired
	private RoleDao roleDao;

    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) { 
    	User user=null;
    	try{
    		Map map =(Map)principals.asList().get(1);
    		User loginUser = new User();
    		loginUser.setEmail(map.get("email").toString());
    		loginUser.setMobile(map.get("mobile").toString());
    		loginUser.setLoginName(map.get("loginName").toString());
    		
    		
    			user =systemService.getByLoginUser(loginUser);
    			user.setRoleList(roleDao.findList(new Role(user)));
    		
    		
		}catch (Exception e){
			String name = (String)getAvailablePrincipal(principals);
			
			user =systemService.getUserByLoginName(name);
		}
		
		Principal principal =new Principal(user, false);
		// 获取当前已登录的用户
		if (Global.TRUE.equals(Global.getConfig("user.multiAccountLogin"))){
			Collection<Session> sessions = getSystemService().getSessionDao().getActiveSessions(true, principal, UserUtils.getSession());
			if (sessions.size() > 0){
				// 如果是登录进来的，则踢出已在线用户
				if (UserUtils.getSubject().isAuthenticated()){
					for (Session session : sessions){
						getSystemService().getSessionDao().delete(session);
					}
				}
				// 记住我进来的，并且当前用户已登录，则退出当前用户提示信息。
				else{
					UserUtils.getSubject().logout();
					throw new AuthenticationException("msg:账号已在其它地方登录，请重新登录。");
				}
			}
		}
		if (user != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			List<Menu> list = UserUtils.getMenuList();
			for (Menu menu : list){
				if (StringUtils.isNotBlank(menu.getPermission())){
					// 添加基于Permission的权限信息
					for (String permission : StringUtils.split(menu.getPermission(),",")){
						info.addStringPermission(permission);
					}
				}
			}
			// 添加用户权限
			info.addStringPermission("user");
			// 添加用户角色信息
			for (Role role : user.getRoleList()){
				info.addRole(role.getEnname());
			}
			// 更新登录IP和时间
			getSystemService().updateUserLoginInfo(user);
			// 记录登录日志
//			LogUtils.saveLog(Servlets.getRequest(), "系统登录");
			return info;
		} else {
			return null;
		}
    }  
    
	
	/**
	 * 清空用户关联权限认证，待下次使用时重新加载
	 */
	@Deprecated
	public void clearCachedAuthorizationInfo(User principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清空所有关联认证
	 * @Deprecated 不需要清空，授权缓存保存到session中
	 */
	@Deprecated
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}
      
	/**
	 * 获取系统业务对象
	 */
	public SystemService getSystemService() {
		if (systemService == null){
			systemService = SpringContextHolder.getBean(SystemService.class);
		}
		return systemService;
	}
}
