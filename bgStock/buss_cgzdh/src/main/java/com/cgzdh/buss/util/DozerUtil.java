package com.cgzdh.buss.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.cgzdh.buss.exception.BusinessException;
import com.google.common.collect.Lists;

@Component
public class DozerUtil {
	@Bean
	private Mapper dozerBeanMapper() {
		List<String> mappingFileUrls = Lists.newArrayList("dozerBeanMapping.xml");
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(mappingFileUrls);
		return mapper;
	}
	
	@Autowired
	Mapper dozerBeanMapper;
	
	public  <T> T map(Serializable source, Class<T> destinationClass){
		if(source==null){
			try {
				return destinationClass.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				throw new BusinessException("创建目标类对象失败");
			}
		}		
		try {
			return dozerBeanMapper.map(source, destinationClass);
		} catch (MappingException e) {
			e.printStackTrace();
			throw new BusinessException("dozer进行对象映射失败，请检查映射文件");
		}		
	}
	
	public <T, S extends Serializable> List<T> map(List<S > list , Class<T> destinationClass){
		List<T> tarList=new ArrayList<T>();
		for(S s:list){
			tarList.add(map(s, destinationClass));
		}
		return tarList;
	}
	public <T, S extends Serializable> Page<T> map(Page<S> page , final Class<T> destinationClass){
		return page.map(new Converter<S, T>(){
			@Override
			public T convert(S source) {
				// TODO Auto-generated method stub
				return map(source,destinationClass);
			}

			
			
		});
	}
}
