package com.cgzdh.buss.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import com.cgzdh.buss.config.AlipayConfig;


/**
 *类名：AlipayNotify
 *功能：支付宝通知处理类
 *详细：处理支付宝各接口通知返回
 * @author abo
 */
public class AlipayNotify {


    private final static String MD5="MD5";



    /**
     * 验证消息是否是支付宝发出的合法消息
     * @param params 通知返回来的参数数组
     * @return 验证结果
     */
    public static boolean verify(Map<String, String> params,AlipayConfig alipayConfig) {
        String sign="";
        String signKey="sign";
        if(params.get(signKey) != null) {sign = params.get(signKey);}
        return getSignVeryfy(params, sign,alipayConfig);
    }

    /**
     * 根据反馈回来的信息，生成签名结果
     * @param Params 通知返回来的参数数组
     * @param sign 比对的签名结果
     * @return 生成的签名结果
     */
	private static boolean getSignVeryfy(Map<String, String> Params, String sign,AlipayConfig alipayConfig) {
    	Map<String, String> sParaNew = AlipayCore.paraFilter(Params);
        String preSignStr = AlipayCore.createLinkString(sParaNew);
        boolean isSign = false;
        if( MD5.equals(alipayConfig.getSignType()) ) {
        	isSign = Md5.verify(preSignStr, sign, alipayConfig.getKey(), alipayConfig.getInputCharset());
        }
        return isSign;
    }

    /**
    * 获取远程服务器ATN结果,验证返回URL
    * @param notifyId 通知校验ID
    * @return 服务器ATN结果
    * 验证结果集：
    * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
    * true 返回正确信息
    * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
    */
    private static String verifyResponse(String notifyId, String partner) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AlipayConfig.ALIPAY_GATEWAY_NEW).append("service=notify_verify&").append("partner=").append(partner).append("&notify_id=").append(notifyId);

        return checkUrl(stringBuilder.toString());
    }

    /**
    * 获取远程服务器ATN结果
    * @param urlvalue 指定URL路径地址
    * @return 服务器ATN结果
    * 验证结果集：
    * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
    * true 返回正确信息
    * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
    */
    private static String checkUrl(String urlvalue) {
        String inputLine = "";

        try {
            URL url = new URL(urlvalue);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection
                .getInputStream()));
            inputLine = in.readLine().toString();
        } catch (Exception e) {
            e.printStackTrace();
            inputLine = "";
        }

        return inputLine;
    }
}
