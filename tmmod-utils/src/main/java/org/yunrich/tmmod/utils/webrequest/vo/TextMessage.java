/**
 * 
 * 上海云之富金融信息服务有限公司
 * Copyright (c) 2014 YunCF,Inc.All Rights Reserved.
 */
package org.yunrich.tmmod.utils.webrequest.vo;

/**
 * 
 * @author think
 * @version $Id: TextMessage.java, v 0.1 2014年9月24日 下午3:28:35 think Exp $
 */
public class TextMessage extends BaseMessage {
 // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
