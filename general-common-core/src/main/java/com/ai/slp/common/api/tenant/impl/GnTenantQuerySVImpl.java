package com.ai.slp.common.api.tenant.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.common.api.tenant.interfaces.IGnTenantQuerySV;
import com.ai.slp.common.api.tenant.param.GnTenantConditon;
import com.ai.slp.common.api.tenant.param.GnTenantVo;
import com.ai.slp.common.constants.Constants;
import com.ai.slp.common.service.business.tenant.IGnTenantBusinessService;
import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;

@Service
@Component
public class GnTenantQuerySVImpl implements IGnTenantQuerySV {
    @Autowired
    private IGnTenantBusinessService gnTenantBusinessService;

    @Override
    public GnTenantVo getTenant(GnTenantConditon gnTennatConditon) throws BusinessException,SystemException {
        if (StringUtils.isEmpty(gnTennatConditon.getTenantId())) {
            throw new BusinessException(Constants.ErrorCode.RESULT_ERROR, "ID不能为空");
        }
        Gson gson = new Gson();
        GnTenantVo result = gson.fromJson(
                gson.toJson(
                        gnTenantBusinessService.selectTenantById(gnTennatConditon.getTenantId())),
                GnTenantVo.class);
        return result;
    }

    @Override
    public List<GnTenantVo> getTenants() throws BusinessException,SystemException {
        return gnTenantBusinessService.selectAllTenant();
    }

}
