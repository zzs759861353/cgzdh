package com.cgzdh.buss.constant;


import com.cgzdh.buss.util.Util;

import java.util.Properties;

public class WxPayProperties {


    public static final String NOTIFY_URL = "/pay/wxpay/notify";
    public static final String KEY="1Q2w3e4r5t6y7u8i9Oa1s2d3f4g5h6j7";
    /**
     * 向微信后台发起预支付的url
     */
    public static String WX_PRE_PAY_URL = "";
    
    public static final String DOWN_LOAD_BILL="/pay/wxpay/downloadBill";
    public static final String GET_OPENID_URL="https://api.weixin.qq.com/sns/oauth2/access_token";
    /**
     * 网页支付
     */
    public static final String TRADE_TYPE_JSAPI = "JSAPI";

    public static final String TRADE_TYPE_QC = "NATIVE";
    public static String DOMAIN="";
   public static String MDOMAIN="";
    public static String APP_ID= "";
    /**
     * 商户id
     */
    public static String MCH_ID = "";
    public static String Fee_Type="CNY";

    public static String defSpBillCreateIp = "127.0.0.1";
    public static String jsapiData="";

    public static void init() {
    
        Properties properties = Util.getProperties("/payconfig/wx/wxconfig.properties");
        WxPayProperties.APP_ID =properties.getProperty("appid");
        WxPayProperties.MCH_ID =properties.getProperty("mch_id");
        WxPayProperties.Fee_Type =properties.getProperty("feeType");
        WxPayProperties.WX_PRE_PAY_URL =properties.getProperty("unifiedorder");
        WxPayProperties.DOMAIN =properties.getProperty("domain");
        WxPayProperties.MDOMAIN =properties.getProperty("mdomain");
        WxPayProperties.jsapiData = Util.getFileData("/payconfig/wx/jsapi.txt");
           
           
    }
    
    
}
