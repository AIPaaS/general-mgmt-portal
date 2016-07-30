package com.ai.slp.common.test.industry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.common.api.industry.interfaces.IIndustrySV;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class IndustryTest {
    
    @Autowired
    private IIndustrySV id;
    
    //@Test
    public void industryTest(){
        id.queryIndustryList();
    }

    @Test
    public void industryTest2(){
        id.queryByIndustryCode("09");
    }
}
