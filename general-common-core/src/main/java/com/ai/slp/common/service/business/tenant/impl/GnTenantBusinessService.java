package com.ai.slp.common.service.business.tenant.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.slp.common.api.tenant.param.GnTenantConditon;
import com.ai.slp.common.api.tenant.param.GnTenantVo;
import com.ai.slp.common.dao.mapper.bo.GnTenant;
import com.ai.slp.common.service.atom.tenant.IGnTenantAtomService;
import com.ai.slp.common.service.business.tenant.IGnTenantBusinessService;

@Component
@Transactional
public class GnTenantBusinessService implements IGnTenantBusinessService {

    @Autowired
    private IGnTenantAtomService gnTenantAtomService;

    @Override
    public GnTenant selectTenantById(String tenantId) {
        return gnTenantAtomService.selectTenantById(tenantId);
    }

	@Override
	public GnTenant selectTenantById(GnTenantConditon gnTennatConditon) {
		 return gnTenantAtomService.selectTenantById(gnTennatConditon.getTenantId());
	}

	@Override
	public List<GnTenantVo> selectAllTenant() {
		List<GnTenantVo> resultList = new ArrayList<GnTenantVo>();
		List<GnTenant> dbList = gnTenantAtomService.selectAllTenant();
		if(!CollectionUtil.isEmpty(dbList)){
			for(GnTenant dbObj:dbList ){
				GnTenantVo vo=new GnTenantVo();
				BeanUtils.copyProperties(vo, dbObj);
				resultList.add(vo);
			}
		}
		
		return resultList;
	}

}
