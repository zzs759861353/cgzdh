package com.cgzdh.buss.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cgzdh.buss.domain.model.AccountDetail;

public interface AccountRepository extends JpaRepository<AccountDetail, String>{
	Page<AccountDetail> findByUserId(String userId,Pageable page);
}