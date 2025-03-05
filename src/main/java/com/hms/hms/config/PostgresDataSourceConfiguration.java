package com.hms.hms.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class PostgresDataSourceConfiguration {

    @Autowired
    DataSourceProperties dataSourceProperties;

    @Bean
    @Primary
    public DataSource dataSource() {

        HikariConfig hikariConfig=new HikariConfig();
        System.out.println("dataSourceProperties.getUrl() = " + dataSourceProperties.getUrl());
        hikariConfig.setJdbcUrl(dataSourceProperties.getUrl().trim());
        hikariConfig.setUsername(dataSourceProperties.getUsername().trim());
        hikariConfig.setPassword(dataSourceProperties.getPassword().trim());
        hikariConfig.setDriverClassName(dataSourceProperties.getDriverClassName().trim());
        System.out.println(hikariConfig.getJdbcUrl().trim());
        System.out.println(hikariConfig.getUsername().trim());
        System.out.println(hikariConfig.getPassword().trim());
        System.out.println(hikariConfig.getDriverClassName().trim());
        

        return new HikariDataSource(hikariConfig);
    }
}
