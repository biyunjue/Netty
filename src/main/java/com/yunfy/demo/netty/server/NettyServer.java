package com.yunfy.demo.netty.server;


import com.yunfy.demo.netty.server.handler.inbound.InBoundHandlerA;
import com.yunfy.demo.netty.server.handler.inbound.InBoundHandlerB;
import com.yunfy.demo.netty.server.handler.inbound.InBoundHandlerC;
import com.yunfy.demo.netty.server.handler.outbound.OutBoundHandlerA;
import com.yunfy.demo.netty.server.handler.outbound.OutBoundHandlerB;
import com.yunfy.demo.netty.server.handler.outbound.OutBoundHandlerC;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;


/**
 * @author yunfy
 * @create 2018-10-13 17:00
 **/
public class NettyServer {
    private static final int PORT = 8000;

    public static void main(String[] args) {
        final ServerBootstrap serverBootstrap = new ServerBootstrap();

        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        serverBootstrap
                .group(boss, worker)
                .channel(NioServerSocketChannel.class)
                //表示系统用于临时存放已完成三次握手的请求的队列的最大长度，如果连接建立频繁，服务器处理创建新连接较慢，可以适当调大这个参数
                .option(ChannelOption.SO_BACKLOG, 1024)
                //开启TCP底层心跳机制
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                //是否开启Nagle算法，true表示关闭，false表示开启
                //如果要求高实时性，有数据发送时就马上发送，就关闭，如果需要减少发送次数减少网络交互，就开启。
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) {
                        // inBound，处理读数据的逻辑链
                        nioSocketChannel.pipeline().addLast(new InBoundHandlerA());
                        nioSocketChannel.pipeline().addLast(new InBoundHandlerB());
                        nioSocketChannel.pipeline().addLast(new InBoundHandlerC());

                        // outBound，处理写数据的逻辑链
                        nioSocketChannel.pipeline().addLast(new OutBoundHandlerA());
                        nioSocketChannel.pipeline().addLast(new OutBoundHandlerB());
                        nioSocketChannel.pipeline().addLast(new OutBoundHandlerC());
                    }
                });

        bind(serverBootstrap, PORT);
    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println(new Date() + ": 端口[" + port + "]绑定成功!");
            } else {
                System.err.println("端口[" + port + "]绑定失败!");
                bind(serverBootstrap, port + 1);
            }
        });
    }
}
