package com.ai.slp.common.api.industry.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.common.api.industry.interfaces.IIndustrySV;
import com.ai.slp.common.api.industry.param.IndustryQueryResponse;
import com.ai.slp.common.service.business.industry.IIndustryBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class IndustrySVImpl implements IIndustrySV{

    private static final Log LOG = LogFactory.getLog(IndustrySVImpl.class);
    
    @Autowired
    private IIndustryBusiSV industryBusiSV;
    
    @Override
    public List<IndustryQueryResponse> queryIndustryList()
            throws BusinessException, SystemException {
        List<IndustryQueryResponse> list = new ArrayList<IndustryQueryResponse>();
        try{
        list = industryBusiSV.queryIndustryList();
        }catch(Exception e){
            LOG.error("操作失败");;
        }
        return list;
    }

    @Override
    public IndustryQueryResponse queryByIndustryCode(String industryCode)
            throws BusinessException, SystemException {
         
        IndustryQueryResponse response = new IndustryQueryResponse();
        try {
            response = industryBusiSV.queryByIndustryCode(industryCode);
        } catch (Exception e) {
            LOG.error("操作失败");
        }
        return response;
    }
    
}
