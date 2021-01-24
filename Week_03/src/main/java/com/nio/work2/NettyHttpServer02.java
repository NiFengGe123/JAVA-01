package com.nio.work2;

import com.nio.work1.HttpInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * Copyright (C), 2021
 * FileName: NettyHttpServer02
 * Author:   xzw
 * Date:     2021/1/24 21:59
 * Description:
 */
public class NettyHttpServer02 {
    private static final int PORT = 8082;

    private static final Integer CHANNEL_BUF_SIZE= 32 * 1024;

    private static final int MAX_RE_QUEEN_SIZE= 128;

    public static void main(String[] args) {
        //声明reactor主从线程数
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(10);

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            //设置启动服务器参数
            //在服务器请求线程满了后，用来临时存放已完成三次握手的请求的最大队列长度
            bootstrap.option(ChannelOption.SO_BACKLOG, MAX_RE_QUEEN_SIZE);
                    //即时发送包，关闭Nagle算法
            bootstrap.option(ChannelOption.TCP_NODELAY, true)
                    //启动心跳，检测客户端连接是否正常
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    //允许重复使用本地址及端口号链接
                    .option(ChannelOption.SO_REUSEADDR, true)
                    //设置接收缓冲区大小
                    .option(ChannelOption.SO_RCVBUF, CHANNEL_BUF_SIZE)
                    //设置发送缓冲区大小
                    .option(ChannelOption.SO_SNDBUF, CHANNEL_BUF_SIZE)
                    //允许多个线程绑定该接口
                    .option(EpollChannelOption.SO_REUSEPORT, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    //重用缓冲区
                    .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);

            bootstrap.group(bossGroup, workerGroup)
            .channel(NioServerSocketChannel.class);
            bootstrap.handler(new LoggingHandler(LogLevel.INFO));
            bootstrap.childHandler(new HttpInitializer02());

            Channel channel = bootstrap.bind(PORT).sync().channel();
            System.out.println("开启nett http2 服务器，端口号：" + PORT);
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
