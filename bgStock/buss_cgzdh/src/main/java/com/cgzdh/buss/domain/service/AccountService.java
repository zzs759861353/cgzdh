package com.cgzdh.buss.domain.service;


import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cgzdh.buss.domain.dto.AccountDto;
import com.cgzdh.buss.domain.model.AccountDetail;
import com.cgzdh.buss.domain.repository.AccountRepository;
import com.cgzdh.buss.util.DateUtil;
import com.cgzdh.buss.util.UUIDTool;

/**
 * 账号信息
 * @author v_bbojiang
 */
@Service
public class AccountService {
	@Autowired
	EntityManager entityManager;
	@Autowired
	private AccountRepository accountRepository;

    /**
     * 获取个人充值记录
     * @param pageSize
     * @param pageNum
     * @param userId
     * @param month
     * @return
     */
    public Page<AccountDetail> getUserAccount(AccountDto ad){
        Pageable pageable = new PageRequest(ad.getNowPage()-1, ad.getSize(),null);
        Page<AccountDetail> page= accountRepository.findByUserId(ad.getUserId(),pageable);
        return page;
    }

    /**
     * 获取机构中的会员充值记录
     * @param pageSize
     * @param pageNum
     * @param agentId
     * @param month
     * @return
     */
    public Page<AccountDetail> getAgentAccount(AccountDto ad){
    	Pageable pageable = new PageRequest(ad.getNowPage()-1, ad.getSize(),null);
    	//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");// 设置日期格式
		 ;// new Date()为获取当前系统时间
		java.sql.Date now = DateUtil.parseUtilDateToSqlDate(new Date());// 获取系统当前时间作为经办日期
		String sql="select t.* from t_Account_Detail t where t.org_id =:orgId and DATE_FORMAT(create_time,'%Y%m')= DATE_FORMAT('"+now+"','%Y%m')";
		Query query=entityManager.createNativeQuery(sql,AccountDetail.class);
		query.setParameter("orgId", ad.getOrgId());
		query.setFirstResult(pageable.getPageNumber()*pageable.getPageSize());
		query.setMaxResults(pageable.getPageSize());
		@SuppressWarnings("unchecked")
		List<AccountDetail> list=query.getResultList();
		query=entityManager.createNativeQuery("select count(1) from ("+sql+") as ouad");		
		query.setParameter("orgId", ad.getOrgId());
		BigInteger count=(BigInteger)query.getResultList().get(0);
		Page<AccountDetail> pageList = new PageImpl<AccountDetail>(list, pageable, count.intValue());
		return pageList;
    }

	public  AccountDetail saveAccount(AccountDetail ad) {
		ad.setId(UUIDTool.getUUID());
		ad.setCreateTime(new Timestamp(System.currentTimeMillis()));
		return accountRepository.save(ad);
		
	}


}
