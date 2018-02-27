package com.cgzdh.buss.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cgzdh.buss.domain.model.TResource;

public interface TResourceRepository extends JpaRepository<TResource, String> {
	@Query(value = "select * from T_RESOURCE a where a.available=?1 or a.available=?2 order by a.order_num ", nativeQuery = true)
	List<TResource> getResource(String a,String b);

	
	// @Query(value = "SELECT title, rownum id  FROM T_RESOURCE t START WITH id = ?1 CONNECT BY PRIOR t.parent_id = id	 order by id desc", nativeQuery = true)

}
