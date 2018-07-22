/**
 * 
 */
package org.yunrich.tmmod.service.wx;

import java.util.List;

import org.yunrich.tmmod.dal.model.UserInfoDO;
import org.yunrich.tmmod.dal.model.edo.UserInfoEDO;

/**
 * @info user_info表的相关操作服务
 * @author DandelionL.Yin
 * @version $Id: WxUserInfoManager.java, v 0.1 2018年7月2日 下午6:46:37 DandelionL.Yin Exp $
 */
public interface WxUserInfoManager {
	/**
	 * 根据微信号查询用户信息：管理功能权限
	 * @param wxOperId
	 * @param codeStr
	 * @return
	 */
	public List<UserInfoDO> selectByWxOperId(String wxOperId,String codeStr);
	
	/**
	 * 根据手机号查询用户信息：使用该微信公众号只能体现录入信息
	 * @param userMobile
	 * @param codeStr
	 * @return
	 */
	public UserInfoDO selectByMobile(String userMobile,String codeStr);
	
	/**
	 * 绑定微信号操作
	 * @param userInfoEDO
	 * @param codeStr
	 * @return
	 */
	int updateForBindWxByMobile(UserInfoEDO userInfoEDO,String codeStr);
}
