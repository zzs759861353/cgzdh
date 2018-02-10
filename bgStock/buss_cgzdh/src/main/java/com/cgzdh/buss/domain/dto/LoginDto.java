package com.cgzdh.buss.domain.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class LoginDto implements Serializable{
	private static final long serialVersionUID = -8583065520343844972L;
	private String ip ;   //服务器IP地址 
	private int    port;            //端口 
	private String user;  //账户 
	private  String passwd;      //密码 
	private String txPwd ;             //通讯密码 
	private String yyb ;              //营业部 
	private String version;       //版本号
}
