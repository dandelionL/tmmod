package org.yunrich.tmmod.utils.webrequest.pojo;

import java.util.List;

/**
 * 
 * @author think
 * @version $Id: SNSUserInfo.java, v 0.1 2014年9月29日 下午6:36:06 think Exp $
 */
public class SNSUserInfo {
    private String openId;
    private String nickname;
    private int sex;
    private String country;
    private String province;
    private String city;
    private String headImgUrl;
    private List<String> privilegeList;
    public String getOperId() {
        return openId;
    }
    public void setOperId(String operId) {
        this.openId = operId;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public int getSex() {
        return sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getHeadImgUrl() {
        return headImgUrl;
    }
    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }
    public List<String> getPrivilegeList() {
        return privilegeList;
    }
    public void setPrivilegeList(List<String> privilegeList) {
        this.privilegeList = privilegeList;
    }
    
    
}
