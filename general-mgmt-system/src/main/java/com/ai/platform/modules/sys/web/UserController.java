/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ai.platform.modules.sys.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ai.platform.common.beanvalidator.BeanValidators;
import com.ai.platform.common.config.Global;
import com.ai.platform.common.persistence.Page;
import com.ai.platform.common.utils.DateUtils;
import com.ai.platform.common.utils.StringUtils;
import com.ai.platform.common.utils.excel.ExportExcel;
import com.ai.platform.common.web.BaseController;
import com.ai.platform.modules.sys.entity.Office;
import com.ai.platform.modules.sys.entity.Role;
import com.ai.platform.modules.sys.entity.User;
import com.ai.platform.modules.sys.service.SystemService;
import com.ai.platform.modules.sys.utils.UserUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 员工信息Controller
 * 
 * @author ThinkGem
 * @version 2013-8-29
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/user")
public class UserController extends BaseController {

	@Autowired
	private SystemService systemService;

	@ModelAttribute
	public User get(@RequestParam(required = false) String id) {
		if (StringUtils.isNotBlank(id)) {
			return systemService.getUser(id);
		} else {
			return new User();
		}
	}

	@RequiresPermissions("sys:user:view")
	@RequestMapping(value = { "index" })
	public String index(User user, Model model) {
		return "modules/sys/userIndex";
	}

	@RequiresPermissions("sys:user:view")
	@RequestMapping(value = { "list", "" })
	public String list(User user, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<User> page = systemService.findUser(new Page<User>(request, response), user);
		model.addAttribute("page", page);
		return "modules/sys/userList";
	}

	@RequiresPermissions("sys:user:view")
	@RequestMapping(value = { "listno" })
	public String listno(User user, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<User> page = systemService.findUser(new Page<User>(request, response), user);
		model.addAttribute("page", page);
		return "modules/sys/usernoList";
	}

	@ResponseBody
	@RequiresPermissions("sys:user:view")
	@RequestMapping(value = { "listData" })
	public Page<User> listData(User user, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<User> page = systemService.findUser(new Page<User>(request, response), user);
		return page;
	}

	@RequiresPermissions("sys:user:view")
	@RequestMapping(value = "form")
	public String form(User user, Model model) {
		if (user.getCompany() == null || user.getCompany().getId() == null) {
			user.setCompany(UserUtils.getUser().getCompany());
		}
		if (user.getOffice() == null || user.getOffice().getId() == null) {
			user.setOffice(UserUtils.getUser().getOffice());
		}
		model.addAttribute("user", user);
		model.addAttribute("allRoles", systemService.findAllRole());
		return "modules/sys/userForm";
	}

	@RequiresPermissions("sys:user:view")
	@RequestMapping(value = "formno")
	public String formno(User user, Model model) {
		if (user.getCompany() == null || user.getCompany().getId() == null) {
			user.setCompany(UserUtils.getUser().getCompany());
		}
		if (user.getOffice() == null || user.getOffice().getId() == null) {
			user.setOffice(UserUtils.getUser().getOffice());
		}
		if (user.getId() != null) {
			List<User> list = new ArrayList<User>();
			User childUser = new User();
			childUser.setId(user.getId());
			childUser.setName(user.getName());
			list.add(childUser);
			model.addAttribute("userList", list);
		} else {
			model.addAttribute("userList", systemService.findAllNoAccountUser());
		}
		model.addAttribute("user", user);
		model.addAttribute("allRoles", systemService.findAllRole());
		return "modules/sys/usernoForm";
	}

	@RequiresPermissions("sys:user:edit")
	@RequestMapping(value = "save")
	public String save(User user, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		if (Global.isDemoMode()) {
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/sys/user/list?repage";
		}
		// 修正引用赋值问题，不知道为何，Company和Office引用的一个实例地址，修改了一个，另外一个跟着修改。
		user.setCompany(new Office(request.getParameter("company.id")));
		user.setOffice(new Office(request.getParameter("office.id")));
		// 如果新密码为空，则不更换密码
		if (StringUtils.isNotBlank(user.getNewPassword())) {
			user.setPassword(SystemService.entryptPassword(user.getNewPassword()));
		}
		if (!beanValidator(model, user)) {
			return form(user, model);
		}
		if (!"true".equals(checkLoginName(user.getOldLoginName(), user.getLoginName()))) {
			addMessage(model, "保存员工信息'" + user.getLoginName() + "'失败，登录名已存在");
			return form(user, model);
		}

		savemethod(user);
		addMessage(redirectAttributes, "保存员工信息'" + user.getLoginName() + "'成功");
		return "redirect:" + adminPath + "/sys/user/list?repage";
	}

	@RequiresPermissions("user")
	@RequestMapping(value = "savenouser")
	public String savenouser(User user, HttpServletRequest request, Model model,
			RedirectAttributes redirectAttributes) {
		if (Global.isDemoMode()) {
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/sys/user/list?repage";
		}
		// 修正引用赋值问题，不知道为何，Company和Office引用的一个实例地址，修改了一个，另外一个跟着修改。
		user.setCompany(new Office(request.getParameter("company.id")));
		user.setOffice(new Office(request.getParameter("office.id")));
		// 如果新密码为空，则不更换密码
		if (StringUtils.isNotBlank(user.getNewPassword())) {
			user.setPassword(SystemService.entryptPassword(user.getNewPassword()));
		}

		// 插入员工信息时给予员工信息默认主题
		if (StringUtils.isNotBlank(user.getTheme())) {
			user.setTheme(Global.getDefTheme());
		}

		// 保存员工信息信息
		systemService.saveUserNoUser(user);

		addMessage(redirectAttributes, "保存员工信息'" + user.getName() + "'成功");
		return "redirect:" + adminPath + "/sys/user/list?repage";
	}

	@RequiresPermissions("sys:user:edit")
	@RequestMapping(value = "saveno")
	public String saveno(User user, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		if (Global.isDemoMode()) {
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/sys/user/listno?repage";
		}
		// 修正引用赋值问题，不知道为何，Company和Office引用的一个实例地址，修改了一个，另外一个跟着修改。
		// user.setCompany(new Office(request.getParameter("company.id")));
		// user.setOffice(new Office(request.getParameter("office.id")));
		// 如果新密码为空，则不更换密码
		if (StringUtils.isNotBlank(user.getNewPassword())) {
			user.setPassword(SystemService.entryptPassword(user.getNewPassword()));
		}
		if (!beanValidator(model, user)) {
			return formno(user, model);
		}
		if (!"true".equals(checkLoginName(user.getOldLoginName(), user.getLoginName()))) {
			addMessage(model, "保存账号'" + user.getLoginName() + "'失败，登录名已存在");
			return formno(user, model);
		}

		savemethod(user);
		addMessage(redirectAttributes, "保存账号'" + user.getLoginName() + "'成功");
		return "redirect:" + adminPath + "/sys/user/listno?repage";
	}

	public void savemethod(User user) {
		// 角色数据有效性验证，过滤不在授权内的角色
		List<Role> roleList = Lists.newArrayList();
		List<String> roleIdList = user.getRoleIdList();
		for (Role r : systemService.findAllRole()) {
			if (roleIdList.contains(r.getId())) {
				roleList.add(r);
			}
		}
		user.setRoleList(roleList);
		// 插入员工信息时给予员工信息默认主题
		if (StringUtils.isNotBlank(user.getTheme())) {
			user.setTheme(Global.getDefTheme());
		}

		// 保存员工信息信息
		systemService.saveUser(user);
		// 清除当前员工信息缓存
		if (user.getLoginName().equals(UserUtils.getUser().getLoginName())) {
			UserUtils.clearCache();
			// UserUtils.getCacheMap().clear();
		}

	}

	@RequiresPermissions("sys:user:edit")
	@RequestMapping(value = "delete")
	public String delete(User user, RedirectAttributes redirectAttributes) {
		if (Global.isDemoMode()) {
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/sys/user/list?repage";
		}
		if (UserUtils.getUser().getId().equals(user.getId())) {
			addMessage(redirectAttributes, "删除员工信息失败, 不允许删除当前员工信息");
		} else if (User.isAdmin(user.getId())) {
			addMessage(redirectAttributes, "删除员工信息失败, 不允许删除超级管理员员工信息");
		} else {
			systemService.deleteUser(user);
			addMessage(redirectAttributes, "删除员工信息成功");
		}
		return "redirect:" + adminPath + "/sys/user/list?repage";
	}

	@RequiresPermissions("sys:user:edit")
	@RequestMapping(value = "deleteno")
	public String deleteno(User user, RedirectAttributes redirectAttributes) {
		if (Global.isDemoMode()) {
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/sys/user/listno?repage";
		}
		if (UserUtils.getUser().getId().equals(user.getId())) {
			addMessage(redirectAttributes, "删除账号失败, 不允许删除当前账号");
		} else if (User.isAdmin(user.getId())) {
			addMessage(redirectAttributes, "删除账号失败, 不允许删除超级管理员账号");
		} else {
			systemService.deleteUser(user);
			addMessage(redirectAttributes, "删除账号成功");
		}
		return "redirect:" + adminPath + "/sys/user/listno?repage";
	}

	/**
	 * 导出员工信息数据
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("sys:user:view")
	@RequestMapping(value = "export", method = RequestMethod.POST)
	public String exportFile(User user, HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) {
		try {
			String fileName = "员工信息数据" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
			Page<User> page = systemService.findUser(new Page<User>(request, response, -1), user);
			new ExportExcel("员工信息数据", User.class).setDataList(page.getList()).write(response, fileName).dispose();
			return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出员工信息失败！失败信息：" + e.getMessage());
		}
		return "redirect:" + adminPath + "/sys/user/list?repage";
	}

	/**
	 * 导入员工信息数据
	 * 
	 * @param file
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("sys:user:edit")
	@RequestMapping(value = "import", method = RequestMethod.POST)
	public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		if (Global.isDemoMode()) {
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/sys/user/list?repage";
		}
		try {
			// 验证导入文件是否合法
			String fileName = file.getOriginalFilename();
			if (StringUtils.isBlank(fileName)) {
				throw new RuntimeException("导入文档为空!");
			} else if (!fileName.toLowerCase().endsWith(".txt")) {
				throw new RuntimeException("文档格式不正确!");
			}
			int successNum = 0;
			int failureNum = 0;
			int alldataNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			InputStream is;
			is = file.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String lineContent;
			while ((lineContent = br.readLine()) != null) {
				if (lineContent.startsWith("#LOGINNAME"))
					continue;
				alldataNum++;
				String[] userInfo = lineContent.split("\\\\t");
				if(userInfo.length !=7){
					failureMsg.append("<br/>数据"+alldataNum+":信息格式不正确;");
					failureNum++;
					continue;
				}
				//封装导入用户信息
				User user =setUserInfo(userInfo);
				try {
					if ("true".equals(checkLoginName("", user.getLoginName()))) {
						user.setPassword(SystemService.entryptPassword(user.getLoginName()+Global.getPasswordRule()));
						BeanValidators.validateWithException(validator, user);
						systemService.saveImportUser(user);
						successNum++;
					} else {
						failureMsg.append("<br/>数据"+alldataNum+":登录名 " + user.getLoginName() + " 已存在; ");
						failureNum++;
					}
				} catch (ConstraintViolationException ex) {
					failureMsg.append("<br/>数据"+alldataNum+":登录名 " + user.getLoginName() + " 导入失败：");
					List<String> messageList = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
					for (String message : messageList) {
						failureMsg.append(message + "; ");
						failureNum++;
					}
				} catch (Exception ex) {
					failureMsg.append("<br/>数据"+alldataNum+":登录名 " + user.getLoginName() + " 导入失败：" + ex.getMessage());
				}
			}
			//关闭文件流
			br.close();
			isr.close();
			is.close();

			if (failureNum > 0) {
				failureMsg.insert(0, "，失败 " + failureNum + " 条员工信息，导入信息如下：");
			}
			addMessage(redirectAttributes, "已成功导入 " + successNum + " 条员工信息" + failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入员工信息失败！失败信息：" + e.getMessage());
		}
		return "redirect:" + adminPath + "/sys/user/listno?repage";
	}
	/**
	 * 封装导入用户信息
	 * @param userInfo
	 * @return user
	 */
	private User setUserInfo(String[] userInfo){
		User user = new User();
		user.setLoginName(userInfo[0]);
		user.setNo(userInfo[1]);
		user.setName(userInfo[2]);
		user.setEmail(userInfo[3]);
		user.setMobile(userInfo[4]);
		user.setCompany(new Office(userInfo[5]));
		user.setOffice(new Office(userInfo[6]));
		user.setDelFlag("0");
		user.setLoginFlag("1");
		
		return user;
	}

	/**
	 * 下载导入员工信息数据模板
	 * 
	 * @param response
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("sys:user:view")
	@RequestMapping(value = "import/template")
	public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
			String fileName = "员工信息数据导入模板.xlsx";
			List<User> list = Lists.newArrayList();
			list.add(UserUtils.getUser());
			new ExportExcel("员工信息数据", User.class, 2).setDataList(list).write(response, fileName).dispose();
			return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息：" + e.getMessage());
		}
		return "redirect:" + adminPath + "/sys/user/list?repage";
	}

	/**
	 * 验证登录名是否有效
	 * 
	 * @param oldLoginName
	 * @param loginName
	 * @return
	 */
	@ResponseBody
	@RequiresPermissions("sys:user:edit")
	@RequestMapping(value = "checkLoginName")
	public String checkLoginName(String oldLoginName, String loginName) {
		if (loginName != null && loginName.equals(oldLoginName)) {
			return "true";
		} else if (loginName != null && systemService.getUserByLoginName(loginName) == null) {
			return "true";
		}
		return "false";
	}

	/**
	 * 员工信息信息显示及保存
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequiresPermissions("user")
	@RequestMapping(value = "info")
	public String info(User user, HttpServletResponse response, Model model) {
		User currentUser = UserUtils.getUser();
		if (StringUtils.isNotBlank(user.getName())) {
			if (Global.isDemoMode()) {
				model.addAttribute("message", "演示模式，不允许操作！");
				return "modules/sys/userInfo";
			}
			currentUser.setEmail(user.getEmail());
			currentUser.setPhone(user.getPhone());
			currentUser.setMobile(user.getMobile());
			currentUser.setRemarks(user.getRemarks());
			currentUser.setPhoto(user.getPhoto());
			systemService.updateUserInfo(currentUser);
			model.addAttribute("message", "保存员工信息信息成功");
		}
		model.addAttribute("user", currentUser);
		model.addAttribute("Global", new Global());
		return "modules/sys/userInfo";
	}

	/**
	 * 返回员工信息信息
	 * 
	 * @return
	 */
	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "infoData")
	public User infoData() {
		return UserUtils.getUser();
	}

	/**
	 * 冻结账号--不允许登录
	 * 
	 * 
	 */
	@RequiresPermissions("sys:user:edit")
	@RequestMapping(value = "prohibit")
	public String prohibitLogin(User user, RedirectAttributes redirectAttributes) {
		user.setLoginFlag("0");
		systemService.updateLoginFalg(user);
		addMessage(redirectAttributes, "冻结改账号成功");
		return "redirect:" + adminPath + "/sys/user/listno?repage";
	}

	/**
	 * 重置密码并发送邮件
	 * 
	 */
	@RequiresPermissions("sys:user:edit")
	@RequestMapping(value = "resetPWD")
	public String resetPWD(User user, RedirectAttributes redirectAttributes) {
		if (StringUtils.isBlank(user.getEmail())) {
			addMessage(redirectAttributes, "重置密码失败，该账号没有维护邮箱");
			return "redirect:" + adminPath + "/sys/user/listno?repage";
		}

		try {
			systemService.resetPassword(user);
		} catch (Exception e) {
			addMessage(redirectAttributes, "密码重置失败！失败信息：" + e.getMessage());
		}

		addMessage(redirectAttributes, "重置密码成功");
		return "redirect:" + adminPath + "/sys/user/listno?repage";
	}

	/**
	 * 修改个人员工信息密码
	 * 
	 * @param oldPassword
	 * @param newPassword
	 * @param model
	 * @return
	 */
	@RequiresPermissions("user")
	@RequestMapping(value = "modifyPwd")
	public String modifyPwd(String oldPassword, String newPassword, Model model) {
		User user = UserUtils.getUser();
		if (StringUtils.isNotBlank(oldPassword) && StringUtils.isNotBlank(newPassword)) {
			if (Global.isDemoMode()) {
				model.addAttribute("message", "演示模式，不允许操作！");
				return "modules/sys/userModifyPwd";
			}
			if (SystemService.validatePassword(oldPassword, user.getPassword())) {
				systemService.updatePasswordById(user.getId(), user.getLoginName(), newPassword);
				model.addAttribute("message", "修改密码成功");
			} else {
				model.addAttribute("message", "修改密码失败，旧密码错误");
			}
		}
		model.addAttribute("user", user);
		return "modules/sys/userModifyPwd";
	}

	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required = false) String officeId,
			HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<User> list = systemService.findUserByOfficeId(officeId);
		for (int i = 0; i < list.size(); i++) {
			User e = list.get(i);
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", "u_" + e.getId());
			map.put("pId", officeId);
			map.put("name", StringUtils.replace(e.getName(), " ", ""));
			mapList.add(map);
		}
		return mapList;
	}

	// @InitBinder
	// public void initBinder(WebDataBinder b) {
	// b.registerCustomEditor(List.class, "roleList", new
	// PropertyEditorSupport(){
	// @Autowired
	// private SystemService systemService;
	// @Override
	// public void setAsText(String text) throws IllegalArgumentException {
	// String[] ids = StringUtils.split(text, ",");
	// List<Role> roles = new ArrayList<Role>();
	// for (String id : ids) {
	// Role role = systemService.getRole(Long.valueOf(id));
	// roles.add(role);
	// }
	// setValue(roles);
	// }
	// @Override
	// public String getAsText() {
	// return Collections3.extractToString((List) getValue(), "id", ",");
	// }
	// });
	// }

	public static void main(String[] args) {
		String a = "zhangsan\\t001\\t张三\\tzhangsan@163.com\\t13333333333\\t0001\\t00011";
		String[] b = a.split("\\\\t");
		System.out.println();
	}
}
