package com.king.kinghand.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DruidDBConfig {
	
	private Logger logger = LoggerFactory.getLogger(DruidDBConfig.class);
	
    @Value("${spring.datasource.url}")    
    private String dbUrl;    
        
    @Value("${spring.datasource.username}")    
    private String username;    
        
    @Value("${spring.datasource.password}")    
    private String password;    
        
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;    
        
    @Bean//声明Bean实例
    @Primary //在同样的datasource中，首先使用被标注的datasource
    public DataSource dataSouce() {
    	
    	DruidDataSource dataSource = new DruidDataSource();
    	dataSource.setUrl(dbUrl);
    	dataSource.setUsername(username);
    	dataSource.setPassword(password);
    	dataSource.setDriverClassName(driverClassName);
    	
    	return dataSource;
    }
    
    
}
