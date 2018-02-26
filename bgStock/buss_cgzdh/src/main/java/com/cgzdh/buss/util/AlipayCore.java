package com.cgzdh.buss.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.methods.multipart.FilePartSource;
import org.apache.commons.httpclient.methods.multipart.PartSource;
import org.apache.commons.lang.StringUtils;


/**
 *类名：AlipayFunction
 *功能：支付宝接口公用函数类
 *详细：该类是请求、通知返回两个文件所调用的公用函数核心处理文件，不需要修改
 * @author abo
 */

public class AlipayCore {

    private final static String SIGN_TYPE ="sign_type";

    private final static String SIGN ="sign";

    private final static String MD5="MD5";

    private final static String SHA = "SHA";

    /** 
     * 除去数组中的空值和签名参数
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    public static Map<String, String> paraFilter(Map<String, String> sArray) {

        Map<String, String> result = new HashMap<String, String>();

        if (sArray == null || sArray.size() <= 0) {
            return result;
        }

        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (StringUtils.isEmpty(value) ||  SIGN.equalsIgnoreCase(key)
                ||  SIGN_TYPE.equalsIgnoreCase(key)) {
                continue;
            }
            result.put(key, value);
        }

        return result;
    }

    /** 
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, String> params) {

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        StringBuilder prestr =  new StringBuilder();

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            //拼接时，不包括最后一个&字符
            if (i == keys.size() - 1) {
                prestr.append(key).append("=").append(value);
            } else {
                prestr.append(key).append("=").append(value).append("&");
            }
        }

        return prestr.toString();
    }



    /** 
     * 生成文件摘要
     * @param strFilePath 文件路径
     * @param fileDigestType 摘要算法
     * @return 文件摘要结果
     */
    public static String getAbstract(String strFilePath, String fileDigestType) throws IOException {
        PartSource file = new FilePartSource(new File(strFilePath));
    	if(MD5.equals(fileDigestType)){
    		return DigestUtils.md5Hex(file.createInputStream());
    	}else if(SHA.equals(fileDigestType)) {
    		return DigestUtils.sha256Hex(file.createInputStream());
    	}
    	else {
    		return "";
    	}
    }
}
