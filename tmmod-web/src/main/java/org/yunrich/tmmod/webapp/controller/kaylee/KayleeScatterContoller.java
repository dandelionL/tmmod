package org.yunrich.tmmod.webapp.controller.kaylee;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/klScatter")
@Controller
public class KayleeScatterContoller {
	
	private static final Logger logger = LoggerFactory.getLogger(KayleeScatterContoller.class);

	@RequestMapping("/binding")
	public String binding(ModelMap model, HttpServletRequest request){
		logger.info("绑定微信公众号开始....");
		return "kaylee/binding";
	}
	@RequestMapping("/bindingConfirm")
	public String bindingConfirm(ModelMap model, HttpServletRequest request){
		logger.info("绑定微信公众号处理");
		return "kaylee/binding";
	}
	
	
	@RequestMapping("/addressLogin")
	public String addressLogin(ModelMap model, HttpServletRequest request){
		logger.info("");
		
		return "";//TODO
	}
}
