package com.resource.kr.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/application.properties")
public class DatabaseConfig
{
    @Bean(name="mysqlDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource moniteurDatasource() {
        return DataSourceBuilder.create().build();
    }
}