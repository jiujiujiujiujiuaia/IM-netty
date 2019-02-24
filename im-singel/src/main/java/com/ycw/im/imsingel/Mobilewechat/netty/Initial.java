package com.ycw.im.imsingel.Mobilewechat.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @Author yuchunwei
 */
public class Initial extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline().addLast(new HttpServerCodec());
        channel.pipeline().addLast(new ChunkedWriteHandler());
        channel.pipeline().addLast(new HttpObjectAggregator(1024 * 64));

        channel.pipeline().addLast(new WebSocketServerProtocolHandler("/ws"));
        channel.pipeline().addLast(new ChatHandler());
    }

    public static void main(String[] args) {

    }
}   
