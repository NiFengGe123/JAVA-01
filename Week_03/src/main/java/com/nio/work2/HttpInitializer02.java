package com.nio.work2;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;


/**
 * Copyright (C), 2021
 * FileName: HttpInitializer02
 * Author:   xzw
 * Date:     2021/1/24 19:51
 * Description:
 */
public class HttpInitializer02 extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(1024*1024));
        pipeline.addLast(new HttpOutboundHandler());
        pipeline.addLast(new HttpHandler02());
    }
}
