package com.cgzdh.buss.domain.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

public class AccountDto {
	  /**
     * 主键id
     */
    @Getter @Setter private String id;
    /**
     * 用户id
     */
    @Getter @Setter private String userId;
    /**
     * 机构id
     */
    @Getter @Setter private String orgId;
    @Getter @Setter private String userName;
    @Getter @Setter private String name;
    /**
     * 金额
     */
    @Getter @Setter private String money;
    /**
     * 创建时间
     */
    @Getter @Setter private Timestamp createTime;
    @Getter @Setter private int size;
    @Getter @Setter private int nowPage;
}
