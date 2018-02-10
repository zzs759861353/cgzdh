package com.cgzdh.buss.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;

public class SieaStatement implements PreparedStatementCreator {
	private String sql;
	private List<Object> valueList;
	public SieaStatement(String sql,List<Object> valueList){
		this.sql=sql;
		this.valueList=valueList;
	}

	@Override
	public PreparedStatement createPreparedStatement(Connection connection)
			throws SQLException {
		PreparedStatement ps = connection.prepareStatement(sql, new String[] {"IOBJECT"});
		int i = 1;
		for (Object value : valueList) {
			if (value instanceof Date) {
				ps.setTimestamp(i, new Timestamp(((Date)value).getTime()));
			} else {
				ps.setObject(i, value);
			}
			i++;
		}
		return ps;
	}

}
