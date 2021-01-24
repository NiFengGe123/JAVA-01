package com.nio.work2.serivce;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public interface RequestFilter {

    /**
     * 请求过滤
     *
     * @param context
     */
    void doFilter(FullHttpRequest request, ChannelHandlerContext context);
}
