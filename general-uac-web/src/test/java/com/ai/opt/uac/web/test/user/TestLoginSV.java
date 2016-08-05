package com.ai.opt.uac.web.test.user;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.exception.RPCSystemException;
import com.ai.opt.data.api.user.interfaces.ILoginSV;
import com.ai.opt.data.api.user.param.UserLoginResponse;
import com.ai.opt.sdk.util.Md5Encoder;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
//@ContextConfiguration({ "/dubbo/provider/dubbo-provider.xml" })
public class TestLoginSV {

	@Autowired
	ILoginSV iLoginSV;
	
	//@Ignore
	@Test
    public void testSSO() throws RPCSystemException{
        String name = "user001";
        UserLoginResponse info = iLoginSV.queryUserByUserName(name);
        System.out.println("result="+JSON.toJSONString(info));
    }
	
	@Test
    public void testSSOa() throws RPCSystemException{
        String name = "123456";
        System.out.println("result="+Md5Encoder.encodePassword(name));
    }
}
