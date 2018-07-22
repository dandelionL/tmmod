/**
 * 
 * 上海云之富金融信息服务有限公司
 * Copyright (c) 2014-2015 YunCF,Inc.All Rights Reserved.
 */
package org.yunrich.tmmod.webapp.controller.kaylee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yunrich.tmmod.service.wx.CoreService;
import org.yunrich.tmmod.utils.SecurityUtil;
import org.yunrich.tmmod.utils.common.WxConstantMessage;


/**
 * 
 * @author DandenlionL
 * @version $Id: WXRecvController.java, v 0.1 2015-11-13 下午5:41:24 DandenlionL Exp $
 */
@Controller
public class WXRecvController {
    @Autowired
    private CoreService coreService;
    
    final static Logger logger = LoggerFactory.getLogger(WXRecvController.class);

    @RequestMapping(value = "/wx/receive" , method =RequestMethod.GET )
    public void index(ModelMap model,HttpServletRequest req,HttpServletResponse rep) {
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");
        
        if(timestamp == null) {
            timestamp ="";
        }
        if(nonce == null) {
            nonce = "";
        }
        if(echostr == null) {
            echostr = "";
        }
        logger.info("收到参数,signature["+signature+"]timestamp["+timestamp+"]nonce["+nonce+"]echostr["+echostr+"]");
        String[] array = {WxConstantMessage.TOKEN,timestamp,nonce};
        Arrays.sort(array);
        String tempStr = array[0]+array[1]+array[2];
        
        logger.info("排序后的数据[{}]",tempStr);
        
        String afterEncodeStr = SecurityUtil.encodeBySHA1(tempStr);
        
        logger.info("加密后的字符串[{}]",afterEncodeStr);
        
        if(afterEncodeStr.equals(signature)){
        	logger.info("校验成功，成为开发者！");
            try {
                PrintWriter out =  rep.getWriter();
                out.write(echostr);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
        	logger.info("校验失败！");
        }
    }
    
    @RequestMapping(value = "/wx/receive" , method =RequestMethod.POST )
    public void index1(ModelMap model,HttpServletRequest request,HttpServletResponse response) throws Exception {
     // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
//        String signature = request.getParameter("signature");
//        String timestamp = request.getParameter("timestamp");
//        String nonce = request.getParameter("nonce");
        
        //防止恶意访问
        //TODO
        logger.info("收到消息[{}]",request.toString());
  
        // 调用核心业务类接收消息、处理消息  
        String respMessage = coreService.processRequest(request);
        logger.info("返回微信服务器数据：["+respMessage,"]");
          
        // 响应消息  
        PrintWriter out = response.getWriter();
        out.print(respMessage);
        out.close();
        
    }
}
