package com.cgzdh.buss.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the T_RESOURCE database table.
 * 
 */
@Data
@Entity
@Table(name="T_RESOURCE")
@NamedQuery(name="TResource.findAll", query="SELECT t FROM TResource t ")
public class TResource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	// @SequenceGenerator(name="T_RESOURCE_ID_GENERATOR", sequenceName="SEQ_A_TResource")
	// @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_RESOURCE_ID_GENERATOR")
	private String id;

	@Column(name="APP_ID")
	private String appId;

	private String available;

	private String descript;

	private String name;

	@Column(name="ORDER_NUM")
	@OrderBy()
	private BigDecimal orderNum;

	@Column(name="PARENT_ID")
	private String parentId;

	private String title;

	@Column(name="TYPE")
	private String type;

	private String url;
	@Column(name="ICON_NAME")
	private String iconName;
	
}