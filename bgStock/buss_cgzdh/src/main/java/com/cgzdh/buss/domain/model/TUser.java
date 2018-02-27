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
@Table(name="T_USER", uniqueConstraints = {
	      @UniqueConstraint(columnNames = {"USER_NAME"})
	})
@NamedQuery(name="TUser.findAll", query="SELECT t FROM TUser t")
@Data
public class TUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	@Column(name="user_name")
	private String userName;
	private String name;
	private String password;
	@Column(name="account_locked_reason")
	private String accountLockedReason;
	private int status;
	@Column(name="head_img_url")
	private String headImgUrl;
	@Column(name="id_number")
	private String idNumber;
	@Column(name="id_type")
	private int idType;
	private String mobile;
	@Column(name="org_id")
	private String orgId;
	private String salt;
	@Column(name="update_time")
	private Timestamp updateTime;
    //@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Timestamp createTime;
	@Column(name="last_active_date")
	private Date lastActiveDate;
	@Column(name="validity_date")
	private Date validityDate;
	private Timestamp amount;
	private String recomender;
	private int userType;


}