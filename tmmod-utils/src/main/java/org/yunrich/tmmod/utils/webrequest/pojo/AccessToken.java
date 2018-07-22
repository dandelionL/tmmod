package org.yunrich.tmmod.utils.webrequest.pojo;

/**
 * 
 * @author think
 * @version $Id: AccessToken.java, v 0.1 2014年9月28日 下午3:26:30 think Exp $
 */
public class AccessToken {
    // 获取到的凭证  
    private String token;  
    // 凭证有效时间，单位：秒  
    private int expiresIn;  
  
    public String getToken() {  
        return token;  
    }  
  
    public void setToken(String token) {  
        this.token = token;  
    }  
  
    public int getExpiresIn() {  
        return expiresIn;  
    }  
  
    public void setExpiresIn(int expiresIn) {  
        this.expiresIn = expiresIn;  
    }  
}
