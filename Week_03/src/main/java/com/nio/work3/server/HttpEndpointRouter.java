package com.nio.work3.server;

import java.util.List;

public interface HttpEndpointRouter {

    /**
     * 路由选择访问服务器
     *
     * @param endpoints
     * @return
     */
    String route(List<String> endpoints);
}
