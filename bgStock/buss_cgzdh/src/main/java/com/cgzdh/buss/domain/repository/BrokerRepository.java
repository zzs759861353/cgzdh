package com.cgzdh.buss.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgzdh.buss.domain.model.Broker;

public interface BrokerRepository extends JpaRepository<Broker, String> {	
	// @Query(value = "SELECT title, rownum id  FROM T_RESOURCE t START WITH id = ?1 CONNECT BY PRIOR t.parent_id = id	 order by id desc", nativeQuery = true)

}
