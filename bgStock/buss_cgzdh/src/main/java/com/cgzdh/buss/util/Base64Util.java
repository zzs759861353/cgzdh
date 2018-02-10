package com.cgzdh.buss.util;
import org.apache.commons.codec.binary.Base64;
import java.io.UnsupportedEncodingException;

public class Base64Util {
	//===========================================================
		//Base64编码,解码
		//===========================================================
		/**
		 * Base64 编码
		 * 
		 * @param src
		 * @return
		 */
		public static String base64Encode(String src) {
			String result = null;
			if (src != null) {
				byte[] bytes = null;
				try {
					bytes = src.getBytes("GBK");
					byte[] rbyte = null;
					rbyte = Base64.encodeBase64(bytes);
					result = new String(rbyte);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			return result;
		}
		
		//kind为GBK或UTF-8格式(严平2013-03-08增加)
		public static String base64Encode(String src,String kind) {
			String result = null;
			if (src != null) {
				byte[] bytes = null;
				try {
					bytes = src.getBytes(kind);
					byte[] rbyte = null;
					rbyte = Base64.encodeBase64(bytes);
					result = new String(rbyte);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			return result;
		}
		
		/**
		 * Base64 解码
		 * 
		 * @param src
		 * @return
		 */
		public static String base64Decode(String src) {
			String result = null;
			if (src != null) {
				byte[] bytes = src.getBytes();
				byte[] rbyte = null;
				rbyte = Base64.decodeBase64(bytes);
				try {
					result = new String(rbyte,"GBK");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			return result;
		}
		//kind为GBK或UTF-8格式(严平2013-03-08增加)
		public static String base64Decode(String src,String kind) {
			String result = null;
			if (src != null) {
				byte[] bytes = src.getBytes();
				byte[] rbyte = null;
				rbyte = Base64.decodeBase64(bytes);
				try {
					result = new String(rbyte,kind);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			return result;
		}
}
