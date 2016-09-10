/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.ai.platform.common.config.Global;
import com.ai.platform.common.service.BaseService;
import com.ai.platform.common.utils.CacheUtils;
import com.ai.platform.common.utils.SpringContextHolder;
import com.ai.platform.common.utils.StringUtils;
import com.ai.platform.modules.sys.dao.MenuDao;
import com.ai.platform.modules.sys.dao.OfficeDao;
import com.ai.platform.modules.sys.dao.RoleDao;
import com.ai.platform.modules.sys.dao.UserDao;
import com.ai.platform.modules.sys.entity.Menu;
import com.ai.platform.modules.sys.entity.Office;
import com.ai.platform.modules.sys.entity.Role;
import com.ai.platform.modules.sys.entity.User;
import com.ai.platform.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 用户工具类
 * 
 * @author ThinkGem  
 * @version 2013-12-05
 */
public class UserUtils {
	private UserUtils(){
		
	}

	private static UserDao userDao = SpringContextHolder.getBean(UserDao.class);
	private static RoleDao roleDao = SpringContextHolder.getBean(RoleDao.class);
	private static MenuDao menuDao = SpringContextHolder.getBean(MenuDao.class);
	private static OfficeDao officeDao = SpringContextHolder.getBean(OfficeDao.class);

	public static final String USER_CACHE = "userCache";
	public static final String USER_CACHE_ID_ = "id_";
	public static final String USER_CACHE_LOGIN_NAME_ = "ln";
	public static final String USER_CACHE_LIST_BY_OFFICE_ID_ = "oid_";
	public static final String USER_CACHE_THEME = "theme";
	public static final String USER_CACHE_THEMEINX = "theme_index";
	public static final String CACHE_ROLE_LIST = "roleList";
	public static final String CACHE_MENU_LIST = "menuList";
	public static final String CACHE_MENU_CHILDLIST = "menuChildList";
	public static final String CACHE_AREA_LIST = "areaList";
	public static final String CACHE_OFFICE_LIST = "officeList";
	public static final String CACHE_OFFICE_ALL_LIST = "officeAllList";
	public static final String CACHE_USER_LIST = "userList";
	public static final String USER_DEFAULT_THEME = Global.getDefTheme();
	
	public static final String SYS_USER_ID ="SYS$SYSUSER$ID";

	private static Map<String, Object> CacheMap = new HashMap<String, Object>();
	
	public static final String BIND_EMAIL = "email/pwd-reset-binemail.xml";
	
	private static List<User> cache_user_data = new ArrayList<User>();
	
	
	public static List<User> getUserList(User user){
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>) getCache(CACHE_USER_LIST);
		if (userList == null || userList.isEmpty() ) {
			
			userList =userDao.findList(user);
			putCache(CACHE_USER_LIST, userList);
		}
		return userList;
	}
	

	/**
	 * 根据ID获取用户
	 * 
	 * @param id
	 * @return 取不到返回null
	 */
	public static User get(String id) {
		User user = (User) CacheUtils.get(USER_CACHE, USER_CACHE_ID_ + id);
		if (user == null) {
			user = userDao.get(id);
			if (user == null) {
				return null;
			}
			user.setRoleList(roleDao.findList(new Role(user)));
			CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
			CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName(), user);
		}
		return user;
	}

	/**
	 * 获取当前用户主题
	 * 
	 * @param id
	 * @return 取不到返回null
	 */
	public static String getTheme() {
		String theme = "";
		String themeIndex = getThemeIndex();
		
		 if(StringUtils.equals(themeIndex, "theme-white")){
			theme= "green";
		}else if(StringUtils.equals(themeIndex, "theme-whbl")){
			theme= "cerulean";
		}else{			
			theme = USER_DEFAULT_THEME;
		}
		return theme;
	}
	/**
	 * 获取当前用户主题
	 * 
	 * @param id
	 * @return 取不到返回null
	 */
	public static String getThemeIndex() {
		String theme = "";
		String theme_index="";
		User user = (User) getUser();
		theme = user.getTheme();

		if(StringUtils.equals(theme, "cerulean") || StringUtils.equals(theme, "default")){
			
			theme_index="theme-whbl";
		}else if(StringUtils.equals(theme, "green")){
			theme_index="theme-white";
		}else{
			theme_index="theme-whbl";
		}
		
	
		return theme_index;
	}
	/**
	 * 根据登录名获取用户
	 * 
	 * @param loginName
	 * @return 取不到返回null
	 */
	public static User getByLoginName(String loginName) {
		User user = (User) CacheUtils.get(USER_CACHE, USER_CACHE_LOGIN_NAME_ + loginName);
		if (user == null) {
			user = userDao.getByLoginName(new User(null, loginName));
			if (user == null) {
				return null;
			}
			user.setRoleList(roleDao.findList(new Role(user)));
			CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
			CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName(), user);
		}
		return user;
	}

	/**
	 * 清除当前用户缓存
	 */
	public static void clearCache() {
		removeCache(CACHE_ROLE_LIST);
		removeCache(CACHE_MENU_LIST);
		removeCache(CACHE_AREA_LIST);
		removeCache(CACHE_OFFICE_LIST);
		removeCache(CACHE_OFFICE_ALL_LIST);
		UserUtils.clearCache(getUser());
	}

	/**
	 * 清除指定用户缓存
	 * 
	 * @param user
	 */
	public static void clearCache(User user) {
		CacheUtils.remove(USER_CACHE, USER_CACHE_ID_ + user.getId());
		CacheUtils.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName());
		CacheUtils.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getOldLoginName());
		if (user.getOffice() != null && user.getOffice().getId() != null) {
			CacheUtils.remove(USER_CACHE, USER_CACHE_LIST_BY_OFFICE_ID_ + user.getOffice().getId());
		}
	}

	/**
	 * 获取当前用户
	 * 
	 * @return 取不到返回 new User()
	 */
	public static User getUser() {
		Principal principal = getPrincipal();
		if (principal != null) {
			User user = get(principal.getId());
		
			if (user != null) {
				return user;
			}
			return new User();
		}
		// 如果没有登录，则返回实例化空的User对象。
		return new User();
	}

	/**
	 * 获取当前用户角色列表
	 * 
	 * @return
	 */
	public static List<Role> getRoleList() {
		@SuppressWarnings("unchecked")
		List<Role> roleList = (List<Role>) getCache(CACHE_ROLE_LIST);
		if (roleList == null) {
			User user = getUser();
			if (user.isAdmin()) {
				roleList = roleDao.findAllList(new Role());
			} else {
				Role role = new Role();
				//role.getSqlMap().put("dsf", BaseService.dataScopeFilter(user.getCurrentUser(), "o", "u"));
				roleList = roleDao.findList(role);
			}
			putCache(CACHE_ROLE_LIST, roleList);
		}
		return roleList;
	}

	/**
	 * 获取当前用户角色分页列表
	 * 
	 * @return
	 */
	public static List<Role> getRoleList(Role role) {
		List<Role> roleList = null;
		User user = getUser();
		if (user.isAdmin()) {
			roleList = roleDao.findAllByParams(role);
		} else {
			//role.getSqlMap().put("dsf", BaseService.dataScopeFilter(user.getCurrentUser(), "o", "u"));
			roleList = roleDao.findListByParams(role);
		}
		return roleList;
	}

	/**
	 * 获取当前用户授权菜单
	 * 
	 * @return
	 */
	
	public static List<Menu> getMenuList() {
		
		return getMenuList(new Menu());
	}
	
	public static List<Menu> getMenuList(Menu menu) {
		@SuppressWarnings("unchecked")
		List<Menu> menuList = (List<Menu>) getCache(CACHE_MENU_LIST);
		
		if (menuList == null) {
			User user = getUser();
			if (user.isAdmin()) {
				menuList = menuDao.findAllList(new Menu());
			} else {
				menu.setUserId(user.getId());
				menuList = menuDao.findByUserId(menu);
			}
			putCache(CACHE_MENU_LIST, menuList);
		}
		return menuList;
	}

	/**
	 * 根据父节点ID获取子节点菜单
	 * 
	 * @return
	 */
	public static List<Menu> getMenuNodesbyId(String id) {
		
		// List<Menu> menuList = (List<Menu>)getCache(CACHE_MENU_CHILDLIST+id);
		// if (menuList == null || menuList.isEmpty()){
		//
		List<Menu> MenuNodes = new ArrayList<Menu>();
		List<Menu> menuList = getMenuList(new Menu());
		for(Menu menu :menuList){
			if((id).equals(menu.getParentId())){
				 MenuNodes.add(menu);
			}
		}

		// putCache(CACHE_MENU_CHILDLIST+menu.getId(), menuList);
		// }
		return MenuNodes;
	}

	


	/**
	 * 获取当前用户有权限访问的部门
	 * 
	 * @return
	 */
	public static List<Office> getOfficeList() {
		@SuppressWarnings("unchecked")
		List<Office> officeList = (List<Office>) getCache(CACHE_OFFICE_LIST);
		if (officeList == null) {
			User user = getUser();
			if (user.isAdmin()) {
				officeList = officeDao.findAllList(new Office());
			} else {
				Office office = new Office();
				office.getSqlMap().put("dsf", BaseService.dataScopeFilter(user, "a", ""));
				officeList = officeDao.findList(office);
			}
			putCache(CACHE_OFFICE_LIST, officeList);
		}
		return officeList;
	}

	/**
	 * 获取当前用户有权限访问的部门
	 * 
	 * @return
	 */
	public static List<Office> getOfficeAllList() {
		@SuppressWarnings("unchecked")
		List<Office> officeList = (List<Office>) getCache(CACHE_OFFICE_ALL_LIST);
		if (officeList == null) {
			officeList = officeDao.findAllList(new Office());
		}
		return officeList;
	}

	/**
	 * 获取授权主要对象
	 */
	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	/**
	 * 获取当前登录者对象
	 */
	public static Principal getPrincipal(){
		Subject subject;
		try{
			System.out.println("Principal---1------");
		    subject = SecurityUtils.getSubject();
		    System.out.println("Principal---2------"+subject.getPrincipal());
		    
//			Principal principal = (Principal)subject.getPrincipal();
		    User user =getByLoginName(subject.getPrincipal()+"");
		    System.out.println("Principal---3------"+user.getId());
		    if(user == null)
		    	return null;
			Principal principal =new Principal(user, false);
			if (principal != null){
				return principal;
			}
//			subject.logout();
		}catch (UnavailableSecurityManagerException e) {
			
		}catch (InvalidSessionException e){
			
		}finally{
			//add by zhouxiaohu 
//			subject =null;
		}
		return null;
	}

	public static Session getSession() {
		try {
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null) {
				session = subject.getSession();
			}
			if (session != null) {
				return session;
			}
			// subject.logout();
		} catch (InvalidSessionException e) {

		}
		return null;
	}

	// ============== User Cache ==============

	public static Object getCache(String key) {
		return getCache(key, null);
	}

	public static Object getCache(String key, Object defaultValue) {
		 Object obj = getCacheMap().get(key);
		//Object obj = getSession().getAttribute(key);
		return obj == null ? defaultValue : obj;
	}

	public static void putCache(String key, Object value) {
		 getCacheMap().put(key, value);
		 //getSession().setAttribute(key, value);
	}

	public static void removeCache(String key) {
		 getCacheMap().remove(key);
		 //getSession().removeAttribute(key);
	}

	 public static Map<String, Object> getCacheMap(){
	 Principal principal = getPrincipal();
	 if(principal!=null){
		 return principal.getCacheMap();
	 }
	 return CacheMap;
	 }

}
