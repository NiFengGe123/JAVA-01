package com.nio.work2.serivce;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpResponse;

public interface ResponseFilter {

    /**
     * 响应数据过滤
     *
     * @param response
     * @param context
     */
    FullHttpResponse doFilter(FullHttpResponse response, ChannelHandlerContext context);
}
