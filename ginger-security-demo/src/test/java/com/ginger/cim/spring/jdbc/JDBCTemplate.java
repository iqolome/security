package com.ginger.cim.spring.jdbc;

import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JDBCTemplate {
	@Test
	public void demo() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource
				.setUrl("jdbc:mysql://www.justginger.top:3306/ucm?useUnicode=yes&characterEncoding=UTF-8&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("Ginger8800!.");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from b7";
		List<CimSQLResult> cimResult = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CimSQLResult.class));
		for (CimSQLResult cimSQLResult : cimResult) {
			System.out.println(cimSQLResult);
		}
	}
}
