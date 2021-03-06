package com.geek.study.aop;

import com.geek.study.demo.DatasourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2021
 * FileName: SwitchDatasourceAOP
 * Author:   xzw
 * Date:     2021/3/5 21:19
 * Description:
 */
@Aspect
@Component
@Lazy(false)
@Order(0)
public class SwitchDatasourceAOP {

    @Before("execution(* com.geek.study.service.*.*(..))")
    public void process(JoinPoint point) {
        String methodName = point.getSignature().getName();
        boolean querySql = methodName.startsWith("get") || methodName.startsWith("count")
                || methodName.startsWith("find") || methodName.startsWith("list")
                || methodName.startsWith("select") || methodName.startsWith("query");
        if (querySql) {
            //只读库
            DatasourceContextHolder.setDatasourceType("selectDatasource");
        } else {
            //写库
            DatasourceContextHolder.setDatasourceType("updateDatasource");
        }
    }
}
