package com.nio.work2.serivce.impl;

import com.nio.work2.serivce.ResponseFilter;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpResponse;
import org.apache.commons.codec.Charsets;

import java.nio.charset.Charset;

/**
 * Copyright (C), 2021
 * FileName: ResponseFilterImpl
 * Author:   xzw
 * Date:     2021/1/24 19:44
 * Description:
 */
public class ResponseFilterImpl implements ResponseFilter {

    private static final String VALUE_STR = "\n 这是响应追加的值嗷：秋天不回来啦 ！哈哈哈哈！";

    /**
     * 设置响应过滤
     *
     * @param response
     * @param context
     */
    @Override
    public FullHttpResponse doFilter(FullHttpResponse response, ChannelHandlerContext context) {

        ByteBuf byteBuf = response.content();
        String content = byteBuf.toString(Charsets.UTF_8);
        content = content+ VALUE_STR;
        response = response.replace(Unpooled.wrappedBuffer(content.getBytes(Charsets.UTF_8)));
        response.headers().set("Content-Length", content.getBytes(Charsets.UTF_8).length);
        return response;
    }
}
