package com.ycw.im.imsingel.learnNettyExample.ClientAndServer.client.handler;


import com.ycw.im.imsingel.learnNettyExample.ClientAndServer.protocol.response.MessageResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponse> {
    @Override
    public void channelRead0(ChannelHandlerContext ctx, MessageResponse messageResponse) {
        if (messageResponse.isUp()) {
            System.out.println("收到[" + messageResponse.getFromUserName() + "]消息:");
        }
        System.out.println(messageResponse.getMessage());

    }
}
