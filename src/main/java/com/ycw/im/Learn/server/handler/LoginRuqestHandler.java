package com.ycw.im.Learn.server.handler;

import com.ycw.im.Learn.protocol.request.LoginRequest;
import com.ycw.im.Learn.protocol.response.LoginResponse;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.HashMap;
import java.util.UUID;

public class LoginRuqestHandler extends SimpleChannelInboundHandler<LoginRequest> {
    static HashMap<String,Channel> map = new HashMap<>();

    static {
        map.put("lsc",null);
        map.put("ycw",null);
        map.put("lhy",null);
        map.put("yq",null);
    }
    @Override
    public void channelRead0(ChannelHandlerContext ctx,LoginRequest loginRequest){
        String username = loginRequest.getUsername();
        System.out.println(username+"请求登陆");
        LoginResponse response = new LoginResponse();
        if(map.get(username)==null){
            String id = UUID.randomUUID().toString().split("-")[0];
            map.put(username,ctx.channel());
            response.setMessage("恭喜您登陆成功,消息格式为对方id+空格+消息内容");
            response.setSuccess(true);
            response.setId(id);
        }
        else{
            response.setSuccess(false);
            response.setMessage("登陆失败，该用户已经被登陆");
        }
        ctx.channel().writeAndFlush(response);
    }
}
