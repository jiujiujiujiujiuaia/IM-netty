package com.ycw.im.imsingel.learnNettyExample.ClientAndServer.server;


import com.ycw.im.imsingel.learnNettyExample.ClientAndServer.codec.nettyCodec.PacketDecoder;
import com.ycw.im.imsingel.learnNettyExample.ClientAndServer.codec.nettyCodec.PacketEncoder;
import com.ycw.im.imsingel.learnNettyExample.ClientAndServer.server.handler.AuthHandler;
import com.ycw.im.imsingel.learnNettyExample.ClientAndServer.server.handler.LoginRuqestHandler;
import com.ycw.im.imsingel.learnNettyExample.ClientAndServer.server.handler.MessageRequestHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;


public class NettyServer {

    public static void init() {
        NioEventLoopGroup group = new NioEventLoopGroup();
        NioEventLoopGroup boss = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap
                .group(group, boss)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    public void initChannel(NioSocketChannel channel) {
                        channel.pipeline().addLast(new PacketDecoder());
                        channel.pipeline().addLast(new LoginRuqestHandler());
                        //添加一个权限校验，避免恶意通过客户端伪造MessageRequest绕过登陆

                        channel.pipeline().addLast(new AuthHandler());

                        channel.pipeline().addLast(new MessageRequestHandler());
                        channel.pipeline().addLast(new PacketEncoder());
                    }
                });
        bind(bootstrap, 6666);
    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println(new Date() + ": 端口[" + port + "]绑定成功!");
            } else {
                System.err.println("端口[" + port + "]绑定失败!");
            }
        });
    }

    public static void main(String[] args) {
        init();
    }
}
