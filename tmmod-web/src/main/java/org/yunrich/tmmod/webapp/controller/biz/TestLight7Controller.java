package org.yunrich.tmmod.webapp.controller.biz;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/biz")
public class TestLight7Controller {
final static Logger logger = LoggerFactory.getLogger(TestLight7Controller.class);
    
    @RequestMapping("/testLight")
    public String thirdCash(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
        logger.info("测试light开始.....");
        return "biz/testLight";
    }
    
    
//    @RequestMapping("/getLight")
//    public @ResponseBody JSONObject getLight(ModelMap model, HttpServletRequest request, HttpServletResponse response,@RequestBody TestLight testLight) throws Exception, IOException {
//    	logger.info("接受light开始...");
//        
//    	logger.info("testLight[{}]"+testLight+"");
//        return new JSONObject(true);
//    }
}
