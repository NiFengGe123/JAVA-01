package com.nio.work2;

import com.nio.work1.HttpHandler;
import com.nio.work2.serivce.RequestFilter;
import com.nio.work2.serivce.impl.RequestFilterImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.ReferenceCountUtil;

/**
 * Copyright (C), 2021
 * FileName: HttpHandler02
 * Author:   xzw
 * Date:     2021/1/24 19:54
 * Description:
 */
public class HttpHandler02 extends ChannelInboundHandlerAdapter {

    private static final String URI = "/test";

    private RequestFilter requestFilter = new RequestFilterImpl();

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            System.out.println("进入了入站自定义方法");
            FullHttpRequest httpRequest = (FullHttpRequest) msg;
            requestFilter.doFilter(httpRequest,ctx);
            String uri = httpRequest.uri();
            if (uri.contains(URI)) {
                HttpHandler.handlerTest(httpRequest, ctx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
