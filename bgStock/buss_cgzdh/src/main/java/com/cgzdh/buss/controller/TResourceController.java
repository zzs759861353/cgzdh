package com.cgzdh.buss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgzdh.buss.domain.dto.TResourceDto;
import com.cgzdh.buss.domain.model.Broker;
import com.cgzdh.buss.domain.service.TResourceService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "菜单接口")
@RequestMapping("/auth")
public class TResourceController {
	@Autowired
	private TResourceService tResourceService;

	@RequestMapping(value = "/tresources", method = RequestMethod.GET)
	public @ResponseBody List<TResourceDto> findAllTResource(@RequestParam String available) {
		return tResourceService.findAll(available);
	}
	
	@RequestMapping(value = "/findBroker", method = RequestMethod.GET)
	public @ResponseBody List<Broker> findBroker() {
		return tResourceService.findBroker();
	}
	
	
}
