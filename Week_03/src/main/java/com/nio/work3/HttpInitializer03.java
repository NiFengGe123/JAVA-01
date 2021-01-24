package com.nio.work3;

import com.nio.work2.HttpOutboundHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * Copyright (C), 2021
 * FileName: HttpInitializer03
 * Author:   xzw
 * Date:     2021/1/24 23:18
 * Description:
 */
public class HttpInitializer03 extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(1204*1024));
        pipeline.addLast(new HttpOutboundHandler());
        pipeline.addLast(new HttpHandler03());
    }
}
