package com.ai.platform.test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.exception.RPCSystemException;
import com.ai.platform.modules.sys.dao.GnAreaDao;
import com.ai.platform.modules.sys.entity.GnArea;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
//@ContextConfiguration({ "/dubbo/provider/dubbo-provider.xml" })
public class Test {

	@Autowired
	GnAreaDao areaDao;
	
	//@Ignore
	@org.junit.Test
    public void testSSO() throws RPCSystemException{
		List<GnArea> list = areaDao.findList(new GnArea());
		System.out.println("");
		while(true){
			
		}
    }
	
	
}
