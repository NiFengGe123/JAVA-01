package com.nio.work1;

import com.nio.work3.server.HttpEndpointRouter;
import com.nio.work3.server.impl.HttpEndpointRouterImpl;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.ReferenceCountUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;

/**
 * Copyright (C), 2021
 * FileName: HttpHandler
 * Author:   xzw
 * Date:     2021/1/24 17:12
 * Description:
 */
public class HttpHandler extends ChannelInboundHandlerAdapter {

    private static final String URI = "/test";

    private static final String SOCKET_SERVER_URL = "http://localhost:8081";

    private static final String DEFAULT_CONTENT = "客官，未能查询到服务器返回值哦！";

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            FullHttpRequest httpRequest = (FullHttpRequest) msg;
            String uri = httpRequest.uri();
            if (uri.contains(URI)) {
                handlerTest(httpRequest, ctx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    public static void handlerTest(FullHttpRequest httpRequest, ChannelHandlerContext context) {
        //使用httpclient 查询服务器
        String content = HttpClientUtil.get(SOCKET_SERVER_URL);
        if (StringUtils.isBlank(content)) {
            content = DEFAULT_CONTENT;
        }
        //设置响应体
        setResponse(httpRequest, context, content);
    }

    /**
     * 使用默认的单个URL服务器地址
     *
     * @param httpRequest
     * @param context
     * @param content
     */
    private static void setResponse(FullHttpRequest httpRequest, ChannelHandlerContext context, String content) {
        FullHttpResponse response = null;
        try {
            response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                    HttpResponseStatus.OK, Unpooled.wrappedBuffer(content.getBytes("UTF-8")));
            response.headers().set("Content-Type", "application/json;charset=utf-8");
            response.headers().setInt("Content-Length", response.content().readableBytes());

            if (httpRequest.headers().contains("requestFilter")) {
                response.headers().set("requestFilter", httpRequest.headers().get("requestFilter"));
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("处理出错:" + e.getMessage());
            response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NO_CONTENT);
        } finally {
            if (httpRequest != null) {
                if (!HttpUtil.isKeepAlive(httpRequest)) {
                    context.write(response).addListener(ChannelFutureListener.CLOSE);
                } else {
                    response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
                    context.write(response);
                }
            }
        }
    }

    /**
     * 使用传入的指定http服务器地址
     *
     * @param httpRequest
     * @param context
     * @param url
     */
    public static void handlerTest(FullHttpRequest httpRequest, ChannelHandlerContext context, String url) {
        //使用httpclient 查询服务器
        String content = HttpClientUtil.get(url);
        if (StringUtils.isBlank(content)) {
            content = DEFAULT_CONTENT;
        }
        //设置响应体
        setResponse(httpRequest, context, content);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
