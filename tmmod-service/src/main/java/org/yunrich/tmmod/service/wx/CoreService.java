package org.yunrich.tmmod.service.wx;

import javax.servlet.http.HttpServletRequest;


/**
 * 
 * @author DandenlionL
 * @version $Id: CoreService.java, v 0.1 2015-12-14 下午6:51:43 DandenlionL Exp $
 */
public interface CoreService {

    /**
     * 处理微信发来的请求 
     *  
     * @param request 
     * @return 
     */  
    public  String processRequest(HttpServletRequest request);
    
    public String getNewsRespMessage(String title,String description,String picUrl,String toUrl,String state,String fromUserName,String toUserName);
}
