package com.ycw.Mobilewechat.netty;

import com.ycw.Mobilewechat.netty.pojo.DataContent;
import com.ycw.Mobilewechat.netty.strategy.Context;
import com.ycw.Mobilewechat.utils.JsonUtils;
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
        System.out.println("收到的消息"+content);
        DataContent dataContent = JsonUtils.jsonToPojo(content, DataContent.class);
        Context.handle(dataContent,channelHandlerContext.channel());

    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
            channels.add(ctx.channel());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("有新的channel");
        super.channelActive(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("有用户被移除");
        super.handlerRemoved(ctx);
    }

    public static void main(String[] args) {

    }
}   
