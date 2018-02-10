package com.cgzdh.buss.constant;

import org.springframework.util.ClassUtils;

/**
 * 支付常量
 * @author v_bbojiang
 */
public class Constants {
	/**
	 * 文件分隔符
	 */
	public static final String SF_FILE_SEPARATOR = System.getProperty("file.separator");
	/**
	 * 行分隔符
	 */
	public static final String SF_LINE_SEPARATOR = System.getProperty("line.separator");
	/**
	 * 路径分隔符
	 */
	public static final String SF_PATH_SEPARATOR = System.getProperty("path.separator");

	public static final String QRCODE_PATH = ClassUtils.getDefaultClassLoader().getResource("static").getPath()+ Constants.SF_FILE_SEPARATOR +"qrcode";

	/**
	 * 微信账单 相关字段 用于load文本到数据库
	 */
	public static final String WEIXIN_BILL = "tradetime, ghid, mchid, submch, deviceid, wxorder, bzorder, openid, tradetype, tradestatus, bank, currency, totalmoney, redpacketmoney, wxrefund, bzrefund, refundmoney, redpacketrefund, refundtype, refundstatus, productname, bzdatapacket, fee, rate";
	
	public static final String PATH_BASE_INFO_XML = Constants.SF_FILE_SEPARATOR +"WEB-INF"+ Constants.SF_FILE_SEPARATOR +"xmlConfig"+ Constants.SF_FILE_SEPARATOR;
	
	public static final String CURRENT_USER = "UserInfo";
	
	public static final String SUCCESS = "success";
	
	public static final String FAIL = "fail";

	public static final String CHARSET = "UTF-8";
	//来自于微信服务号产生的key
	public static final String AESkeyStr = "qazwsxed";
	
}
