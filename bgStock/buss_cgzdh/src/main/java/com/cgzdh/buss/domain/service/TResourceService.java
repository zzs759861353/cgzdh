package com.cgzdh.buss.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgzdh.buss.domain.dto.TResourceDto;
import com.cgzdh.buss.domain.model.Broker;
import com.cgzdh.buss.domain.model.TResource;
import com.cgzdh.buss.domain.repository.BrokerRepository;
import com.cgzdh.buss.domain.repository.TResourceRepository;

@Service
public class TResourceService extends BaseService {
	@Autowired
	private TResourceRepository tResourceRepository;
	@Autowired
	private BrokerRepository brokerRepository;

	public List<TResourceDto> findAll() {
		List<TResource> tResourceList = tResourceRepository.getResource();
		List<TResourceDto> tResourceDtoList = new ArrayList<TResourceDto>();
		for (TResource tResource : tResourceList) {
			TResourceDto tResourceDto = dozerUtil.map(tResource, TResourceDto.class);
			tResourceDtoList.add(tResourceDto);
		}
		return tResourceDtoList;
	}
	public List<Broker> findBroker() {
		List<Broker> list = brokerRepository.findAll();		
		return list;
	}


}
