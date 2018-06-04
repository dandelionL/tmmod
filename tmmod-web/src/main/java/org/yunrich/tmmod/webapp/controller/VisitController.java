/**
 * 
 * 上海云之富金融信息服务有限公司
 * Copyright (c) 2014 YunCF,Inc.All Rights Reserved.
 */
package org.yunrich.tmmod.webapp.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yunrich.tmmod.service.VisiterDbService;

@Controller
public class VisitController {
	private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    VisiterDbService visiterDbService;

    @RequestMapping("/index")
    public String index(ModelMap model) {
    	logger.info("just Test For Log4j");
        return "index";
    }

    @RequestMapping("/visitWebDb")
    public String visitWebDb(ModelMap model, HttpServletRequest request) {
    	visiterDbService.checkDbStat();
    	logger.info("just Test For db");
        return "visitWebDb";
    }
}
