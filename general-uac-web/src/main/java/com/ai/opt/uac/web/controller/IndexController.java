package com.ai.opt.uac.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
    	/*GnTenantConditon cond=new GnTenantConditon();
    	cond.setTenantId("BIS-ST");
    	GnTenantVo res=DubboConsumerFactory.getService(IGnTenantQuerySV.class).getTenant(cond);
    	
    	request.setAttribute("tenant", res);*/
    	
        return new ModelAndView("jsp/index/index");
    }
    
    /*
    private static final String TEMPLATE_JSP="template.jsp";
    private static final String WELCOME_JSP="welcome.jsp";

    @RequestMapping("/index2")
    public String index(HttpSession session) {
        String decoratorPath = tenant.getFramePageTemplate();
        String welcomePath="/index.jsp";
        if(!StringUtil.isBlank(decoratorPath)){
            welcomePath=decoratorPath.replace(TEMPLATE_JSP, WELCOME_JSP);           
        }
        return "forward:"+welcomePath;
    }*/
}
