package com.nio.work3.server.impl;

import com.nio.work3.server.HttpEndpointRouter;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

/**
 * Copyright (C), 2021
 * FileName: HttpEndpointRouterImpl
 * Author:   xzw
 * Date:     2021/1/24 23:12
 * Description:
 */
public class HttpEndpointRouterImpl implements HttpEndpointRouter {

    /**
     * 随机路由
     *
     * @param endpoints
     * @return
     */
    @Override
    public String route(List<String> endpoints) {
        if (endpoints == null || endpoints.size() < 1) {
            return null;
        }
        int number = RandomUtils.nextInt(0, endpoints.size());
        return endpoints.get(number);
    }
}
