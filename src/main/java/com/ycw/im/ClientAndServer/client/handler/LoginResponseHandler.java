package com.ycw.im.ClientAndServer.client.handler;


import com.ycw.im.ClientAndServer.protocol.response.LoginResponse;
import com.ycw.im.ClientAndServer.util.LoginUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponse> {
    @Override
    public void channelRead0(ChannelHandlerContext ctx,LoginResponse response){
        System.out.println(response.getMessage());
        if(response.isSuccess()){
            LoginUtil.set(ctx.channel());
            LoginUtil.setUserName(ctx.channel(),response.getUserName());;
        }
    }

}
