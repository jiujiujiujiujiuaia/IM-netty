package com.ycw.im.imsingel.Mobilewechat.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author yuchunwei
 */
public class Server {
    private final static Server INSTANCE = new Server();

    private EventLoopGroup mainGroup;
    private EventLoopGroup subGroup;
    private ServerBootstrap server;
    private ChannelFuture future;
    private Server(){
        mainGroup = new NioEventLoopGroup();
        subGroup = new NioEventLoopGroup();
        server = new ServerBootstrap();
        server.group(mainGroup,subGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new Initial());
    }

    public static Server getInstance(){
        return INSTANCE;
    }
    public void start(int port){
        future = server.bind(port);
        System.err.println("netty server 启动，端口号为"+port);
    }

}   
