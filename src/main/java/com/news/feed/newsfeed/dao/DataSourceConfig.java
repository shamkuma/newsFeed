package com.news.feed.newsfeed.dao;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:dbconfig.properties")
public class DataSourceConfig {
	@Value("${dbdriver}")
	private String dbDriver;
	
	@Value("${dburl}")
	private String dbUrl;
	
	@Value("${dbuser}")
	private String user;
	
	@Value("${dbpass}")
	private String pass;
	
	@Bean(name="oracledbconnection")
	public DataSource createDataSource() {
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName(dbDriver);
		datasource.setUrl(dbUrl);
		datasource.setUsername(user);
		datasource.setPassword(pass);
		return datasource;
		
	}
	
	@Bean(name="jdbcTemplate")
	public JdbcTemplate jdbcTemplate(@Autowired @Qualifier("oracledbconnection") DataSource ds) {
		
		return new JdbcTemplate(ds);
	}

}
