package com.cgzdh.buss.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;


import lombok.Data;


/**
 * The persistent class for the T_USER database table.
 * 
 */
@Entity
@Table(name="broker")
@Data
public class Broker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String ip ;  //服务器IP地址
	private int port;          //端口      
	private String txPwd ;             //通讯密码
	private String  yyb ;              //营业部
	private String version;      //版本号
	private String name;


}