package com.cgzdh.buss.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class HttpClientUtil {
	// 单例模式
	private static HttpClientUtil instance;
	private static String queueName = null ;
	private static String baseurl = "";
	

	
	public static HttpClientUtil getInstance() {
		if (instance == null) {
			instance = new HttpClientUtil();
		}
		return instance;
	}
	
	/**
	 * httpClient的get请求方式2
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doGet(String url) throws Exception {
		HttpClient httpClient = new HttpClient(new HttpClientParams(),new SimpleHttpConnectionManager());//释放之后关闭连接
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(50000);    
		httpClient.getParams().setParameter( HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");;    
		//设置Http连接超时为5秒
		System.out.println(url);
		GetMethod getMethod = new GetMethod(url);                                              //生成 GetMethod 对象并设置参数
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);                                 //设置 get 请求超时为 5 秒
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());//设置请求重试处理，用的是默认的重试处理：请求三次
		//getMethod.setRequestHeader("appcode",queueName);
		
		String response = "";
		try {
			// 判断访问的状态码
			int statusCode = httpClient.executeMethod(getMethod);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("请求出错: " + getMethod.getStatusLine());
			}
			InputStream resStream = getMethod.getResponseBodyAsStream();  
			BufferedReader br = new BufferedReader(  new InputStreamReader(resStream,"GBK"));  
			StringBuffer resBuffer = new  StringBuffer();   
			String resTemp = "" ;   
			while ((resTemp = br.readLine()) !=  null ){   
				resBuffer.append(resTemp);  
			}  
			response = resBuffer.toString(); 

		} catch (HttpException e) {
			System.out.println("请检查输入的URL!");// 发生致命的异常，可能是协议不对或者返回的内容有问题
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("发生网络异常!");// 发生网络异常
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("发生网络异常!");// 发生网络异常
			e.printStackTrace();
		} finally {
			getMethod.releaseConnection();// 释放连接
		}
		return response;
	}
	
}