package com.cgzdh.buss.domain.service.pay.alipay;


import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.SignatureException;

public final class AliMd5 {

    private static Logger logger = LoggerFactory.getLogger(AliMd5.class);

    private AliMd5() {
    }


    public static String encode(String origin, String charsetName) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetName == null || "".equals(charsetName)) {
                resultString = Hex.encodeHexString(md.digest(resultString.getBytes()));
            } else {
                resultString = Hex.encodeHexString(md.digest(resultString.getBytes(charsetName)));
            }
        } catch (Exception e) {
            AliMd5.logger.error("md5 encode fail", e);
        }
        return resultString;
    }

    public static String encode(byte[] data) {

        String resultString = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = Hex.encodeHexString(md.digest(data));
        } catch (Exception e) {
            AliMd5.logger.error("md5 encode fail", e);
        }

        return resultString;
    }

    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param sign 签名结果
     * @param key 密钥
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static boolean verify(String text, String sign, String key, String input_charset) {
    	text = text + key;
    	String mysign = DigestUtils.md5Hex(AliMd5.getContentBytes(text, input_charset));
        return mysign.equals(sign);
    }

    /**
     * @param content
     * @param charset
     * @return
     * @throws SignatureException
     * @throws UnsupportedEncodingException 
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }
    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param key 密钥
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static String sign(String text, String key, String input_charset) {
    	text = text + key;
        return DigestUtils.md5Hex(AliMd5.getContentBytes(text, input_charset));
    }
}
