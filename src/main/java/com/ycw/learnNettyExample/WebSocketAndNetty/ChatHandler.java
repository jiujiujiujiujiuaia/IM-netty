package com.ycw.learnNettyExample.WebSocketAndNetty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @Author yuchunwei
 */
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame msg) throws Exception {
        String content = msg.text();
        System.out.println("收到的消息"+msg);
        //对所有在线的用户广播
        for(Channel channel : channels){
            channel.writeAndFlush(new TextWebSocketFrame("广播 ：某用户发送了消息"+content));
        }

    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
            channels.add(ctx.channel());
    }

    public static void main(String[] args) {

    }
}   
