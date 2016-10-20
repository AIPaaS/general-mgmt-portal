package com.ai.platform.modules.sys.task;

import java.util.List;

import com.ai.platform.common.config.Global;
import com.ai.platform.modules.sys.entity.Office;
import com.ai.platform.modules.sys.entity.User;
import com.ai.platform.modules.sys.service.OfficeService;
import com.ai.platform.modules.sys.service.SystemService;

public class UserThead extends Thread {
	private OfficeService officeService;
	private SystemService systemService;
	private String[] userInfo;

	UserThead(String[] userInfo, OfficeService officeService, SystemService systemService) {
		this.userInfo = userInfo;
		this.officeService = officeService;
		this.systemService = systemService;
	}

	public void run() {

		try {
			User user = new User();
			user.setNo(userInfo[0]);
			user.setName(userInfo[1]);
			user.setEmail(userInfo[2]);
			user.setMobile(userInfo[3]);
			if (!userInfo[2].isEmpty() && userInfo[2].length() >= 1) {
				user.setLoginName(userInfo[2].substring(0, userInfo[2].indexOf("@")));
				user.setPassword(SystemService.entryptPassword(Global.getPasswordRule()));
			} 
			user.setLoginFlag("1");
			// // 验证公司编码
			// if (!userInfo[4].isEmpty()) {
			// Office company = new Office();
			// company.setCode(userInfo[4]);
			// List<Office> companyList = officeService.find(company);
			// if (!companyList.isEmpty()) {
			// company = companyList.get(0);
			// user.setCompany(company);
			// }
			// }
			// 验证部门编码
			if (!userInfo[5].isEmpty()) {
				Office office = new Office();
				office.setCode(userInfo[5]);
				List<Office> officeList = officeService.find(office);
				if (!officeList.isEmpty()) {
					office = officeList.get(0);
					user.setOffice(office);
				}
			}
			user.setDelFlag(userInfo[6]);

			User findUser = systemService.getUserByNo(userInfo[0]);
			if (findUser != null) {
				findUser.setName(userInfo[1]);
				findUser.setEmail(userInfo[2]);
				findUser.setMobile(userInfo[3]);
				// 验证公司编码
				findUser.setCompany(user.getCompany());
				findUser.setOffice(user.getOffice());
				findUser.setDelFlag(userInfo[6]);
				systemService.saveImportUser(findUser);
			} else {
				systemService.saveImportUser(user);
			}
			System.out.println("NO:"+userInfo[0]+",Name:"+userInfo[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
