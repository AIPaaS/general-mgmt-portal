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
			if (!userInfo[1].isEmpty() && userInfo[1].length() >= 1) {
				user.setLoginName(userInfo[1]);
				user.setPassword(SystemService.entryptPassword(Global.getPasswordRule()));
			} 
			user.setName(userInfo[2]);
			user.setEmail(userInfo[3]);
			user.setMobile(userInfo[4]);
			
			user.setLoginFlag("1");
			
			 // 验证公司编码
			 if (!userInfo[5].isEmpty()) {
				 Office company = new Office();
				 company.setCode(userInfo[5]);
				 List<Office> companyList = officeService.find(company);
				 if (!companyList.isEmpty()) {
					 company = companyList.get(0);
					 user.setCompany(company);
				 }
			 }
			// 验证部门编码
			if (!userInfo[6].isEmpty()) {
				Office office = new Office();
				office.setCode(userInfo[6]);
				List<Office> officeList = officeService.find(office);
				if (!officeList.isEmpty()) {
					office = officeList.get(0);
					user.setOffice(office);
				}
			}
			user.setDelFlag(userInfo[7]);

			User findUser = systemService.getUserByNo(userInfo[0]);
			if (findUser != null) {
				findUser.setNo(userInfo[0]);
				findUser.setLoginName(userInfo[1]);
				findUser.setName(userInfo[2]);
				findUser.setEmail(userInfo[3]);
				findUser.setMobile(userInfo[4]);
				// 验证公司编码
				findUser.setCompany(user.getCompany());
				findUser.setOffice(user.getOffice());
				findUser.setDelFlag(userInfo[7]);
				systemService.saveImportUser(findUser);
			} else {
				systemService.saveImportUser(user);
			}
			System.out.println("NO:"+userInfo[0]+",Name:"+userInfo[2]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
