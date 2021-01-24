package com.nio.work3;

import com.nio.work1.HttpHandler;
import com.nio.work2.serivce.RequestFilter;
import com.nio.work2.serivce.impl.RequestFilterImpl;
import com.nio.work3.server.HttpEndpointRouter;
import com.nio.work3.server.impl.HttpEndpointRouterImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2021
 * FileName: HttpHandler03
 * Author:   xzw
 * Date:     2021/1/24 23:20
 * Description:
 */
public class HttpHandler03 extends ChannelInboundHandlerAdapter {

    private static final String URI = "/test";

    private RequestFilter requestFilter = new RequestFilterImpl();

    private HttpEndpointRouter endpointRouter = new HttpEndpointRouterImpl();

    private List<String> httpList = new ArrayList<>(2);

    {
        httpList.add("http://localhost:8081");
        httpList.add("http://localhost:8084");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            System.out.println("进入了 work 3 入站自定义方法");
            FullHttpRequest httpRequest = (FullHttpRequest) msg;
            requestFilter.doFilter(httpRequest, ctx);
            String uri = httpRequest.uri();
            if (uri.contains(URI)) {
                String url = endpointRouter.route(httpList);
                HttpHandler.handlerTest(httpRequest, ctx, url);
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
