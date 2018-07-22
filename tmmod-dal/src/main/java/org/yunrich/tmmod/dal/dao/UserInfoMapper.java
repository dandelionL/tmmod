package org.yunrich.tmmod.dal.dao;

import java.util.List;

import org.yunrich.tmmod.dal.model.UserInfoDO;
import org.yunrich.tmmod.dal.model.edo.UserInfoEDO;

public interface UserInfoMapper {
    public List<UserInfoDO> selectByWxOperId(String wxOperId);
    public UserInfoDO selectByMobile(String userMobile);
    public int updateForBindWxByMobile(UserInfoEDO userInfoEDO);
}