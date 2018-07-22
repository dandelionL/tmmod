package org.yunrich.tmmod.utils.webrequest.pojo;

/**
 * 
 * @author think
 * @version $Id: WeixinOauth2Token.java, v 0.1 2014年9月29日 下午5:58:29 think Exp $
 */
public class WeixinOauth2Token {
    private String accessToken;
    private int expiresIn;
    private String refreshToken;
    private String openId;
    private String scope;
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public int getExpiresIn() {
        return expiresIn;
    }
    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
    public String getRefreshToken() {
        return refreshToken;
    }
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
    public String getOpenId() {
        return openId;
    }
    public void setOpenId(String openId) {
        this.openId = openId;
    }
    public String getScope() {
        return scope;
    }
    public void setScope(String scope) {
        this.scope = scope;
    }
    
}
