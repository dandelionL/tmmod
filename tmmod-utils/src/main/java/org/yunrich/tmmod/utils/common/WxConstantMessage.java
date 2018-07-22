package org.yunrich.tmmod.utils.common;


/**
 * 
 * @author DandelionL
 * @version $Id: WxConstantMessage.java, v 0.1 2014-7-3 下午1:55:01 DandelionL Exp $
 */
public class WxConstantMessage {
    
    /** 系统说明*/
    public static final String SYS_TITLE = "Kaylee的工具公众号";
    
    /** 公众号账号*/
    public static final String APPID = "wx1fabd7ce196b517d";
    
    public static final String APPSECRET = "c122997fb2130c4be08b2b3b88fad868";
    
    /** 本系统的域名*/
    public static final String SYS_URL = "http://wyqpy3.natappfree.cc/tmmod";
    
    /** 微信配置 TOKEN*/
    public static final String TOKEN = "0739ed3ecad16742";

	/** 系统默认字符集*/
	public static final String DEFAUT_CHARSET_UTF_8 = "UTF-8";
	
	/** 系统交互默认的Md5Salt*/
	public static final String DEFAUT_MD5_SALT = "";
	
	/** 和外部交互，验证以及返回MD5 位数 16*/
	public static final int CHECK_MD5_FIGURE_16 = 16;
	
	/** 作为校验值，验证以及返回MD5 位数 4*/
    public static final int CHECK_MD5_FIGURE_4 = 4;
	
	/** pos机交互，校验MAC值，对PosDevId字段截取位数，index 0--8*/
	public static final int CHECK_MAC_POSDEVID_INDEX_8 = 8;
	
	/** pos机交互，校验MAC值，对PosId字段截取位数，index 0--8*/
	public static final int CHECK_MAC_POSID_INDEX_8 = 8;
	
	/** 默认Y值*/
	public static final String PUBLIC_Y = "Y";
	
	/** 默认N值*/
    public static final String PUBLIC_N = "N";
    
    /** 微信Id占位符 */
     public static final String WX_ID_PLACEHOLDER = "WXID";
}
