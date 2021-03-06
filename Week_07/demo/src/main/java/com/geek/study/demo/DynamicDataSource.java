package com.geek.study.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2021
 * FileName: DynamicDataSource
 * Author:   xzw
 * Date:     2021/3/5 21:31
 * Description:
 */
@Component
@Primary
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Autowired
    @Qualifier("selectDatasource")
    private DataSource selectDatasource;

    @Autowired
    @Qualifier("updateDatasource")
    private DataSource updateDatasource;

    @Override
    protected Object determineCurrentLookupKey() {
        return DatasourceContextHolder.getDatasourceType();
    }

    @Override
    public void afterPropertiesSet() {
        Map<Object,Object> map = new HashMap<>();
        map.put("selectDatasource",selectDatasource);
        map.put("updateDatasource",updateDatasource);
        setTargetDataSources(map);
        setDefaultTargetDataSource(selectDatasource);
        super.afterPropertiesSet();
    }
}
