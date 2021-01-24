package com.nio.work2;

import com.nio.work2.serivce.ResponseFilter;
import com.nio.work2.serivce.impl.ResponseFilterImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.FullHttpResponse;

/**
 * Copyright (C), 2021
 * FileName: HttpOutboundHandler
 * Author:   xzw
 * Date:     2021/1/24 20:01
 * Description:
 */
public class HttpOutboundHandler extends ChannelOutboundHandlerAdapter {
    private ResponseFilter responseFilter = new ResponseFilterImpl();

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("进行了出站方法");
        FullHttpResponse response = (FullHttpResponse) msg;
        response = responseFilter.doFilter(response, ctx);
        ctx.write(response, promise);
    }

    @Override
    public void flush(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
