package com.cgzdh.buss.domain.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class TUserDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String userName;
	private String name;
	private String password;
	private String accountLockedReason;
	private int status;
	private String headImgUrl;
	private String idNumber;
	private int idType;
	private String mobile;
	private String orgId;
	private String salt;
	private Date updateTime;
	private Timestamp createTime;
	private Date last_activeTate;
	private Date validityDate;
	private Timestamp amount;
	private String recomender;
	private String recommendId;

}
