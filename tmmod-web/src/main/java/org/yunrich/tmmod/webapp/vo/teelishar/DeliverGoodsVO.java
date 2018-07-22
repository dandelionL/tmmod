/**
 * 
 */
package org.yunrich.tmmod.webapp.vo.teelishar;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.yunrich.tmmod.utils.enums.ExpressCompanyEnum;

/**
 * @info 发送货物请求VO
 * @author DandelionL.Yin
 * @version $Id: DeliverGoodsVO.java, v 0.1 2018年7月2日 下午4:22:56 DandelionL.Yin Exp $
 */
public class DeliverGoodsVO implements Serializable{
	private static final long serialVersionUID = 4709298400297859796L;
	
	private String wxOperId;//登陆微信号
	private String mobile;//手机号
	private String name;//姓名
	private String provId;//省份
	private String areaId;//地区
	private String address;//地址
	private List<GoodsTypeListVO> goodsList;//货物单
	
	private ExpressCompanyEnum expressCompany;//快递公司
	
    public String getWxOperId() {
		return wxOperId;
	}
	public void setWxOperId(String wxOperId) {
		this.wxOperId = wxOperId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProvId() {
		return provId;
	}
	public void setProvId(String provId) {
		this.provId = provId;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<GoodsTypeListVO> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<GoodsTypeListVO> goodsList) {
		this.goodsList = goodsList;
	}
	public ExpressCompanyEnum getExpressCompany() {
		return expressCompany;
	}
	public void setExpressCompany(ExpressCompanyEnum expressCompany) {
		this.expressCompany = expressCompany;
	}
	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
