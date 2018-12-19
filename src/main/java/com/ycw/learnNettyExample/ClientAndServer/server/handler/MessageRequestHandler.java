package com.ycw.learnNettyExample.ClientAndServer.server.handler;

import com.ycw.learnNettyExample.ClientAndServer.protocol.request.MessageRequest;
import com.ycw.learnNettyExample.ClientAndServer.protocol.response.MessageResponse;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequest> {
    @Override
    public void channelRead0(ChannelHandlerContext ctx,MessageRequest request){
        Channel channel ;
        MessageResponse messageResponse = new MessageResponse();
        System.out.println(request.getFromUsername()+"正在发送消息");
        if((channel = LoginRuqestHandler.chatList.get(request.getToUserName()))!=null){
            messageResponse.setMessage(request.getMessage());
            messageResponse.setToUserName(request.getToUserName());
            messageResponse.setFromUserName(request.getFromUsername());
            messageResponse.setUp(true);
            channel.writeAndFlush(messageResponse);
        }
        else {
            messageResponse.setUp(false);
            messageResponse.setMessage("对方没有上线");
            ctx.channel().writeAndFlush(messageResponse);
        }
    }
}
