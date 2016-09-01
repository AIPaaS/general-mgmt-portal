package com.ai.platform.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.sdk.components.sequence.util.SeqUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/spring-context.xml" })
public class TestSeq {
	@org.junit.Test
	public void testseq(){
		System.out.println(SeqUtil.getNewId("SYS$SYSWAITJOBS$ID"));
	}
}
