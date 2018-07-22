/**
 * 
 */
package org.yunrich.tmmod.utils.enums;

/**
 * @info 快递公司枚举
 * @author DandelionL.Yin
 * @version $Id: ExpressCompanyEnum.java, v 0.1 2018年7月2日 下午5:00:56 DandelionL.Yin Exp $
 */
public enum ExpressCompanyEnum {
	YUANTONG("圆通"),
	SHUNFENG("顺丰"),
	ZHONGTONG("中通"),
	YUNDA("韵达")
	;
	
	private ExpressCompanyEnum(String expressCompanyDesc){
		this.expressCompanyDesc = expressCompanyDesc;
	}
	
	private String expressCompanyDesc;

	public String getExpressCompanyDesc() {
		return expressCompanyDesc;
	}
	public void setExpressCompanyDesc(String expressCompanyDesc) {
		this.expressCompanyDesc = expressCompanyDesc;
	}
	
	public static ExpressCompanyEnum getEnumByName(String name){
		for(ExpressCompanyEnum e:ExpressCompanyEnum.values()){
			if(e.name().equals(name)){
				return e;
			}
		}
		return null;
	}
}
