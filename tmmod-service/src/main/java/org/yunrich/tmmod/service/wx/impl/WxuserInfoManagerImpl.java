/**
 * 
 */
package org.yunrich.tmmod.service.wx.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yunrich.tmmod.dal.dao.UserInfoMapper;
import org.yunrich.tmmod.dal.model.UserInfoDO;
import org.yunrich.tmmod.dal.model.edo.UserInfoEDO;
import org.yunrich.tmmod.service.wx.WxUserInfoManager;

/**
 * @info user_info表的相关操作服务
 * @author DandelionL.Yin
 * @version $Id: WxuserInfoManagerImpl.java, v 0.1 2018年7月2日 下午6:53:22 DandelionL.Yin Exp $
 */
@Service
public class WxuserInfoManagerImpl implements WxUserInfoManager {
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	private final Logger logger = LoggerFactory.getLogger(WxuserInfoManagerImpl.class);

	/* (non-Javadoc)
	 * @see org.yunrich.tmmod.service.wx.WxUserInfoManager#selectByWxOperId(java.lang.String)
	 */
	@Override
	public List<UserInfoDO> selectByWxOperId(String wxOperId,String codeStr) {
		logger.info("code[{}]根据访问微信OperId[{}]，查看是否绑定",codeStr,wxOperId);
		
		List<UserInfoDO> userInfoList =  userInfoMapper.selectByWxOperId(wxOperId);
		
		logger.info("code[{}]根据访问微信OperId[{}]，返回数据[{}]",codeStr,wxOperId,userInfoList.toString());
		return userInfoList;
	}

	/* (non-Javadoc)
	 * @see org.yunrich.tmmod.service.wx.WxUserInfoManager#selectByMobile(java.lang.String)
	 */
	@Override
	public UserInfoDO selectByMobile(String userMobile,String codeStr) {
		logger.info("code[{}]根据预登记手机号[{}]，查看是否绑定",codeStr,userMobile);
		UserInfoDO userInfo =  userInfoMapper.selectByMobile(userMobile);
		logger.info("code[{}]根据预登记手机号[{}]，返回数据[{}]",codeStr,userMobile,userInfo.toString());
		
		return userInfo;
	}

	/* (non-Javadoc)
	 * @see org.yunrich.tmmod.service.wx.WxUserInfoManager#updateForBindWxByMobile(org.yunrich.tmmod.dal.model.edo.UserInfoEDO)
	 */
	@Override
	public int updateForBindWxByMobile(UserInfoEDO userInfoEDO,String codeStr) {
		return userInfoMapper.updateForBindWxByMobile(userInfoEDO);
	}

}
