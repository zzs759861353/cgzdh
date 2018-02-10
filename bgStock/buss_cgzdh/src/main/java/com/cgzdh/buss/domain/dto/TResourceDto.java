package com.cgzdh.buss.domain.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class TResourceDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String type;
	private String available;
	private String descript;
	private String orderNum;
	private String name;
	private String url;
	private String title;
	private String parentId;
	private String appId;
	private String iconName;
}
