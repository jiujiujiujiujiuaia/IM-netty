package com.ycw.im.imsingel.learnNettyExample.BrowserAndClient;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;

import java.nio.charset.Charset;

/**
 * @Author yuchunwei
 */
public class ResponseHandler extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject httpObject) throws Exception {
        Channel channel = ctx.channel();
        ByteBuf byteBuf = ctx.alloc().buffer();
        byteBuf.writeBytes("Hello Netty ".getBytes(Charset.forName("UTF-8")));
//        ByteBuf content = Unpooled.copiedBuffer("Hello netty~", CharsetUtil.UTF_8);
        System.out.println("ip :" + channel.remoteAddress());
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                HttpResponseStatus.OK, byteBuf);
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
        response.headers().set(HttpHeaderNames.CONTENT_LENGTH, byteBuf.readableBytes());

        ctx.writeAndFlush(response);
    }

    public static void main(String[] args) {

    }
}   
