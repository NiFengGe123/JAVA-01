package com.nio.work2.serivce.impl;

import com.nio.work2.serivce.RequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * Copyright (C), 2021
 * FileName: RequestFilterImpl
 * Author:   xzw
 * Date:     2021/1/24 19:40
 * Description:
 */
public class RequestFilterImpl implements RequestFilter {


    @Override
    public void doFilter(FullHttpRequest request, ChannelHandlerContext context) {
        request.headers().set("requestFilter","this is filter value ~~");
    }
}
