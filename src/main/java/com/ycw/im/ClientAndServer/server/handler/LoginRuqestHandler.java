package com.ycw.im.ClientAndServer.server.handler;

import com.ycw.im.ClientAndServer.protocol.request.LoginRequest;
import com.ycw.im.ClientAndServer.protocol.response.LoginResponse;
import com.ycw.im.ClientAndServer.protocol.response.MessageResponse;
import com.ycw.im.ClientAndServer.util.LoginUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LoginRuqestHandler extends SimpleChannelInboundHandler<LoginRequest> {
    static HashMap<String,Channel> chatList = new HashMap<>();

    static {
        chatList.put("lsc",null);
        chatList.put("ycw",null);
        chatList.put("lhy",null);
        chatList.put("yq",null);
    }
    @Override
    public void channelRead0(ChannelHandlerContext ctx,LoginRequest loginRequest){
        String username = loginRequest.getUsername();
        System.out.println(username+"请求登陆");
        LoginResponse response = new LoginResponse();
        if(chatList.get(username)==null){
            LoginUtil.set(ctx.channel());
            chatList.put(username,ctx.channel());
            response.setMessage("恭喜您登陆成功,消息格式为对方用户名+空格+消息内容\n" + notice(username,"上线了"));
            response.setSuccess(true);
            response.setUserName(username);
        }
        else{
            response.setSuccess(false);
            response.setMessage("登陆失败，该用户已经被登陆");
        }
        ctx.channel().writeAndFlush(response);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        String username = "" ;
        for(Map.Entry<String,Channel> map : chatList.entrySet()){
            if(map.getValue() == ctx.channel()){
                username = map.getKey();
                break;
            }
        }
        chatList.put(username,null);
        notice(username,"下线了");
    }

    private String notice(String username,String status){
        MessageResponse response = new MessageResponse();
        String str = "线上人数为%d人 %s" ;
        int count  =0;
        for(Map.Entry<String,Channel> map : chatList.entrySet()){
            if(map.getValue() != null && !map.getKey().equals(username)){
                count++;
                str +=  map.getKey() + ",";
                response.setMessage(username + status);
                response.setUp(true);
                response.setFromUserName("系统");
                map.getValue().writeAndFlush(response);
            }
        }
        if(count > 0){
            str = String.format(str,count,"线上用户列表为[");
            char[] chars  = str.toCharArray();
            chars[chars.length -1] = ' ';
            str = new String(chars);
            str +="]";
        }
        else str = String.format(str,count,"");

        return str;

    }
}
