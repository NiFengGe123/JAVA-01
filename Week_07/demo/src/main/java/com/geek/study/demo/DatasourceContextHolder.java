package com.geek.study.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2021
 * FileName: DatasourceContextHolder
 * Author:   xzw
 * Date:     2021/3/5 21:24
 * Description:
 */
@Component
@Lazy(false)
public class DatasourceContextHolder {
    private static  ThreadLocal<String> contextholder = new ThreadLocal<>();

    public static void setDatasourceType(String datasourceType) {
        contextholder.set(datasourceType);
    }

    public static String getDatasourceType() {
        return contextholder.get();
    }

    public static void clearDatasourceType() {
        contextholder.remove();
    }
}
