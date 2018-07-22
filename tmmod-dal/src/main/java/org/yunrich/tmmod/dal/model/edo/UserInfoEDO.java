/**
 * 
 */
package org.yunrich.tmmod.dal.model.edo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.yunrich.tmmod.dal.model.UserInfoDO;

/**
 * @info 
 * @author DandelionL.Yin
 * @version $Id: UserInfoEDO.java, v 0.1 2018年7月2日 下午6:39:33 DandelionL.Yin Exp $
 */
public class UserInfoEDO extends UserInfoDO {
	private String oldStat;

	public String getOldStat() {
		return oldStat;
	}

	public void setOldStat(String oldStat) {
		this.oldStat = oldStat;
	}
	
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
