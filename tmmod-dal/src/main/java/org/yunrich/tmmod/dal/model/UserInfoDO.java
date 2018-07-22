package org.yunrich.tmmod.dal.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class UserInfoDO {
    /**
     * 
     */
    private String userMobile;

    /**
     * 
     */
    private String userName;

    /**
     * 
     */
    private String wxOperId;

    /**
     * 
     */
    private String stat;

    /**
     * 
     */
    private String userRole;

    /**
     * 
     */
    private Date creatTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     * @return user_mobile 
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     * 
     * @param userMobile 
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    /**
     * 
     * @return user_name 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 
     * @return wx_oper_id 
     */
    public String getWxOperId() {
        return wxOperId;
    }

    /**
     * 
     * @param wxOperId 
     */
    public void setWxOperId(String wxOperId) {
        this.wxOperId = wxOperId;
    }

    /**
     * 
     * @return stat 
     */
    public String getStat() {
        return stat;
    }

    /**
     * 
     * @param stat 
     */
    public void setStat(String stat) {
        this.stat = stat;
    }

    /**
     * 
     * @return user_role 
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * 
     * @param userRole 
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * 
     * @return creat_time 
     */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
     * 
     * @param creatTime 
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    /**
     * 
     * @return update_time 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     * @param updateTime 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}