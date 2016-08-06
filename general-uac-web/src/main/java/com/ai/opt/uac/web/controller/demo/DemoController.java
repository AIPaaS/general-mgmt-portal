package com.ai.opt.uac.web.controller.demo;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;



@RequestMapping("/demo")
@Controller
public class DemoController {

    private static final Logger LOG = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping("/page")
    public ModelAndView index(HttpServletRequest request) {

        ModelAndView view = new ModelAndView("demo/page");
        return view;
    }
    
}
