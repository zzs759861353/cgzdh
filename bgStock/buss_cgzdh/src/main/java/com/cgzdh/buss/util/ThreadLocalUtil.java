package com.cgzdh.buss.util;

import javax.servlet.http.HttpServletRequest;

public class ThreadLocalUtil {
	static ThreadLocal<HttpServletRequest> requestThreadLocal=new ThreadLocal<HttpServletRequest>();
	public static void setHttpServletRequest(HttpServletRequest request){
		requestThreadLocal.set(request);
	}
	public static HttpServletRequest getHttpServletRequest(){
		return requestThreadLocal.get();
	}
	public static void removeHttpServletRequest(){
		requestThreadLocal.remove();
	}
		
}
