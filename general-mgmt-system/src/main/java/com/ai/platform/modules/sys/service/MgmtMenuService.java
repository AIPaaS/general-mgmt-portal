package com.ai.platform.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.platform.common.service.TreeService;
import com.ai.platform.modules.sys.dao.MgmtMenuDao;
import com.ai.platform.modules.sys.entity.MgmtMenu;
@Service
@Transactional(readOnly = true)
public class MgmtMenuService extends TreeService<MgmtMenuDao, MgmtMenu>{
	@Transactional(readOnly = true)
	public List<MgmtMenu> findList(MgmtMenu menu){
		if(menu != null){
			menu.setParentIds(menu.getParentIds()+"%");
			return dao.findByParentIdsLike(menu);
		}
		return  new ArrayList<MgmtMenu>();
	}
}
