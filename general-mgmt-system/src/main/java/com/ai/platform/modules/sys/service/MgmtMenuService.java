package com.ai.platform.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.platform.common.service.CrudService;
import com.ai.platform.modules.sys.dao.MgmtMenuDao;
import com.ai.platform.modules.sys.entity.MgmtMenu;
@Service
@Transactional(readOnly = true)
public class MgmtMenuService extends CrudService<MgmtMenuDao, MgmtMenu>{
	public List<MgmtMenu> findList(MgmtMenu sysMenu) {
		return super.findList(sysMenu);
	}
	
}
