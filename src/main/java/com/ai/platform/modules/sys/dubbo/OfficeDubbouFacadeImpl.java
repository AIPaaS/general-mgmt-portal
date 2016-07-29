package com.ai.platform.modules.sys.dubbo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.platform.modules.sys.entity.Office;
import com.ai.platform.modules.sys.service.OfficeService;
@Service("officeDubbouFacade")
public class OfficeDubbouFacadeImpl implements OfficeDubbouFacade{
	@Autowired
	private OfficeService officeService;
	
	//	取全部组织信息
	public List<Office> getOfficeList(){
		
		return officeService.findAll();	
	}

	// 
	
	
}
