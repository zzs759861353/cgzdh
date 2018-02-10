package com.cgzdh.buss.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式化工具
 * 
 * @author wuyf
 * 
 */
public class DateFormator {

	/** 日期格式 */
	private static final String pattern = "yyyy-MM-dd";
	
	/**
	 * 将日期格式化为String YYYY-MM-DD
	 * 
	 * @param value
	 * @return
	 */
	public static String toStringValue(Date date) {
		if (null == date) {
			return null;
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		return sf.format(date);
	}

	/**
	 * 将String格式化为日期
	 * 
	 * @param value
	 * @return
	 * @throws ParseException
	 * @throws ParseException
	 */
	public static Date toDateValue(String value) throws ParseException {
		if (null == value) {
			return null;
		}
		return new SimpleDateFormat(pattern).parse(value);
	}
	
	
	/**
	 * 将Long格式化为日期
	 * 只支持yyyyMMdd格式字符串转换成日期
	 * @param value
	 * @return
	 * @throws ParseException
	 * @throws ParseException
	 */
	public static Date toDateValue(Long value) {
		if (null == value) {
			return null;
		}
		try {
			return new SimpleDateFormat("yyyyMMdd").parse(value.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将日期格式化为Long
	 * 
	 * @param value
	 * @return
	 * @throws ParseException
	 * @throws ParseException
	 */
	public static Long toLongValue(Date date) {
		if (null == date) {
			return null;
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		return Long.parseLong(sf.format(date));
	}
	
	/**
	 * 将时间格式化为Long
	 * 
	 * @param value
	 * @return
	 * @throws ParseException
	 * @throws ParseException
	 */
	public static Long toLong14Value(Date dateTime) {
		if (null == dateTime) {
			return null;
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		return Long.parseLong(sf.format(dateTime));
	}
	
	/**
	 * 月数增减方法
	 * 
	 * @param date
	 *            Integer类型yyyyMM格式
	 * @param months
	 *            增加的月数正负均可
	 * @return Integer类型yyyyMM格式
	 */
	public static final Integer addMonths(Integer date, Integer months) {
		Integer result = 0;
		String month = "";
		if (date.equals(null) || date <= 0) {
			return result;
		} else if (date.toString().length() != 6) {
			return result;
		}
		Integer dateYear = new Integer(date.toString().substring(0, 4));
		Integer dateMonth = new Integer(date.toString().substring(4, 6));
		Integer allMonths = (dateYear * 12 + dateMonth) + months;
		dateYear = allMonths / 12;
		dateMonth = allMonths % 12;
		if (dateMonth > 0 && dateMonth < 10) {
			month = "0" + dateMonth;
		} else if (dateMonth == 0) {
			dateYear = dateYear - 1;
			month = "12";
		} else {
			month = dateMonth.toString();
		}
		result = new Integer(dateYear + "" + month);
		return result;
	}
}
