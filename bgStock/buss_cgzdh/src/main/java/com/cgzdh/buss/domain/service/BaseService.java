package com.cgzdh.buss.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgzdh.buss.util.DozerUtil;

@Service
public class BaseService {
	@Autowired	
	protected DozerUtil dozerUtil;

}
