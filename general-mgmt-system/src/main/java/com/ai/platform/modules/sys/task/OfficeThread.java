package com.ai.platform.modules.sys.task;

import java.util.List;

import com.ai.platform.common.config.Global;
import com.ai.platform.modules.sys.entity.GnArea;
import com.ai.platform.modules.sys.entity.Office;
import com.ai.platform.modules.sys.service.GnAreaService;
import com.ai.platform.modules.sys.service.OfficeService;

public class OfficeThread extends Thread {
	private OfficeService officeService;
	private GnAreaService areaService;
	
	private String[] userInfo;
	public OfficeThread(String[] userInfo,OfficeService officeService, GnAreaService areaService){
		this.userInfo=userInfo;
		this.officeService=officeService;
		this.areaService =areaService;
	}
	
	public void run() {
		Office officeInfo = setOfficeInfo(userInfo);
		Office office = new Office();
		office.setCode(officeInfo.getCode());
		List<Office> list = officeService.find(office);
		if (!list.isEmpty()) {
			office = list.get(0);
			office.setCode(officeInfo.getCode());
			office.setName(officeInfo.getName());
			office.setParent(officeInfo.getParent());
			office.setUseable(officeInfo.getUseable());
			officeService.save(office);

		} else {
			officeService.save(officeInfo);
		}
	}

	/**
	 * 封装导入部门信息
	 * 
	 * @param officeInfo
	 * @return Office
	 */
	private Office setOfficeInfo(String[] officeInfo) {
		Office office = new Office();
		office.setCode(officeInfo[0]);
		office.setName(officeInfo[1]);
		if (!officeInfo[2].isEmpty()) {
			Office parentOffice = new Office();
			parentOffice.setCode(officeInfo[2]);
			List<Office> parentList = officeService.find(parentOffice);
			if (!parentList.isEmpty()) {
				office.setParent(parentList.get(0));
			}
		}
		GnArea gnArea = areaService.getByCode("00");
		if (gnArea != null) {
			office.setGnArea(gnArea);
		}
		office.setUseable(officeInfo[3]);
		office.setGrade("1");// 默认导入的部门级别为：一级
		office.setTenantId(Global.getTenantID());
		return office;
	}


}
