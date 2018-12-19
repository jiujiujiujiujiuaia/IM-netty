package com.ycw.learnNettyExample.ClientAndServer.codec.nettyCodec;

import com.ycw.learnNettyExample.ClientAndServer.codec.Codec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class PacketDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List out) {
        out.add(Codec.INSTANCE.decode(in));
    }

}
