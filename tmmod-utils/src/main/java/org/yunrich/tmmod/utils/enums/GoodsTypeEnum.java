/**
 * 
 */
package org.yunrich.tmmod.utils.enums;

/**
 * @info 缇丽莎尔 teelishar 货物
 * @author DandelionL.Yin
 * @version $Id: GoodsTypeEnum.java, v 0.1 2018年7月2日 下午3:32:13 DandelionL.Yin Exp $
 */
public enum GoodsTypeEnum {
	NVHUANG("女皇"),
	YAMEI("亚美"),
	GELI("隔离"),
	XIMIANNAI("洗面奶"),
	RU("乳"),
	SHUI("水"),
	ANMOGAO("按摩膏"),
	QIDIAN("气垫"),
	MIANMO("面膜"),
	YIDINGSHOU("一定瘦");
	
	private GoodsTypeEnum(String goodsTypeDesc){
		this.goodsTypeDesc = goodsTypeDesc;
	}
	
	private String goodsTypeDesc;
	
	public String getGoodsTypeDesc() {
		return goodsTypeDesc;
	}
	public void setGoodsTypeDesc(String goodsTypeDesc) {
		this.goodsTypeDesc = goodsTypeDesc;
	}
	
	public static GoodsTypeEnum getEnumByName(String goodType){
		for(GoodsTypeEnum e:GoodsTypeEnum.values()){
			if(e.name().equals(goodType)){
				return e;
			}
		}
		return null;
	}
}
