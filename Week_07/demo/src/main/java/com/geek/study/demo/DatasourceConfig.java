package com.geek.study.demo;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Copyright (C), 2021
 * FileName: DatasourceConfig
 * Author:   xzw
 * Date:     2021/3/5 21:27
 * Description:
 */
@Configuration
public class DatasourceConfig {

    @Bean(name = "selectDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource selectDatasource(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "updateDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource updateDatasource(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
