/**
 * 
 */
package org.yunrich.tmmod.webapp.vo.teelishar;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.yunrich.tmmod.utils.enums.GoodsTypeEnum;

/**
 * @info 
 * @author DandelionL.Yin
 * @version $Id: GoodsTypeListVO.java, v 0.1 2018年7月2日 下午4:31:08 DandelionL.Yin Exp $
 */
public class GoodsTypeListVO implements Serializable {
	private static final long serialVersionUID = 1286770466385084502L;

	private GoodsTypeEnum goodsType;//货物类别
	private int num;//数量
	
	public GoodsTypeEnum getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(GoodsTypeEnum goodsType) {
		this.goodsType = goodsType;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
