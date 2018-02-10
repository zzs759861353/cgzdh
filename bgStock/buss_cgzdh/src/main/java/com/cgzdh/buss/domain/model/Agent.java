package com.cgzdh.buss.domain.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 机构信息
 * @author v_bbojiang
 */
@Entity
@Table(name="t_agent")
public class Agent  {
	@Id
    @Getter @Setter private String id;
	 @Getter @Setter private String name;

    @Getter @Setter private String agreementFilePath;

    @Getter @Setter private String certificate;

    @Getter @Setter private String bankAccount;

    @Getter @Setter private String bankName;

    @Getter @Setter private Integer status;
    @Getter @Setter private Timestamp createDate;

}
