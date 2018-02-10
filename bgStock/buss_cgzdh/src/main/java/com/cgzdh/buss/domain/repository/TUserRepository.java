package com.cgzdh.buss.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgzdh.buss.domain.model.TUser;

public interface TUserRepository extends JpaRepository<TUser, String> {
	 List<TUser> findByUserName(String userName);

}
