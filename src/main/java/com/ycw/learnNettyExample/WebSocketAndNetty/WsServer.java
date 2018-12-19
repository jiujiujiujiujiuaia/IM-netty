package com.ycw.learnNettyExample.WebSocketAndNetty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author yuchunwei
 */
public class WsServer {

    private static void init(){
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap
                    .group(bossGroup,workGroup)
                        .channel(NioServerSocketChannel.class)
                    .childHandler(new Init());
            ChannelFuture future = bootstrap.bind(8088).sync();
            future.channel().closeFuture().sync();
        }
        catch (Exception e){
            e.printStackTrace();
        }
       finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {

    }
}   
