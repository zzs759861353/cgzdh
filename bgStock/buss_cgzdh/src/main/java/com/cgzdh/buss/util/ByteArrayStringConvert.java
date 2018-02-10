package com.cgzdh.buss.util;

import org.apache.commons.codec.binary.Base64;
import org.dozer.CustomConverter;

public class ByteArrayStringConvert implements CustomConverter {

	public Object convert(Object destinationFieldValue,
            Object sourceFieldValue, Class<?> destinationClass,
            Class<?> sourceClass) {
        Object returnVale = null;
        if(sourceFieldValue!=null){
        	if(sourceFieldValue instanceof byte[] ){
        		returnVale = Base64.encodeBase64String((byte[])sourceFieldValue);
        	}
        }
        return returnVale;
	}

}
