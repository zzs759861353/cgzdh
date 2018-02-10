package com.cgzdh.buss.ymlbean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component  
@ConfigurationProperties(prefix="hebsicp") //接收application.yml中的myProps下面的属性 
public class HebsicpBean {
	String hostandport;
	String appcode;
	public String getHostandport() {
		return hostandport;
	}
	public void setHostandport(String hostandport) {
		this.hostandport = hostandport;
	}
	public String getAppcode() {
		return appcode;
	}
	public void setAppcode(String appcode) {
		this.appcode = appcode;
	}
	
	
	
}
