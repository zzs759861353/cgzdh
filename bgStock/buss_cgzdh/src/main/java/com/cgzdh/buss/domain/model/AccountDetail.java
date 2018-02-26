package com.cgzdh.buss.domain.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 个人账户明细
 * @author v_bbojiang
 */
@Entity
@Table(name="T_ACCOUNT_DETAIL")
public class AccountDetail {

    /**
     * 主键id
     */
	@Id
    @Getter @Setter private String id;
    /**
     * 用户id
     */
	@Column(name="user_id")
    @Getter @Setter private String userId;
    /**
     * 机构id
     */
	@Column(name="org_id")
    @Getter @Setter private String orgId;
    /**
     * 金额
     */
    @Getter @Setter private Double money;
    /**
     * 创建时间
     */
    @Column(name="userName")
    @Getter @Setter private String userName;
    @Getter @Setter private String name;
    @Column(name="create_time")
    @Getter @Setter private Timestamp createTime;

}
