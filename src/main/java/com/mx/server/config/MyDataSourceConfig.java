package com.mx.server.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
@Configuration
public class MyDataSourceConfig {
    @Autowired
    DataSourceProperties dataSourceProperties;

    @Primary
    @Bean
    public DataSource dataSource(){
        HikariConfig hikariConfig=new HikariConfig();
        hikariConfig.setJdbcUrl(dataSourceProperties.getUrl());
        hikariConfig.setUsername(dataSourceProperties.getUsername());
        hikariConfig.setPassword(dataSourceProperties.getPassword());
        hikariConfig.setDriverClassName(dataSourceProperties.getDriverClassName());
        HikariDataSource hikariDataSource=new HikariDataSource(hikariConfig);
        return hikariDataSource;
    }
}
