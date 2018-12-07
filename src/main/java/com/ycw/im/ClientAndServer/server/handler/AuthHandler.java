package com.ycw.im.ClientAndServer.server.handler;

import com.ycw.im.ClientAndServer.util.LoginUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author yuchunwei
 */
public class AuthHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(LoginUtil.isLogin(ctx.channel())){
            ctx.pipeline().remove(this);
            super.channelRead(ctx, msg);
        }
        else {
            ctx.channel().close();
        }

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        if (LoginUtil.isLogin(ctx.channel())) {
            System.out.println("当前连接登录验证完毕，无需再次验证, AuthHandler 被移除");
        } else {
            System.out.println("无登录验证，强制关闭连接!");
        }
    }

    public static void main(String[] args) {

    }
}   
