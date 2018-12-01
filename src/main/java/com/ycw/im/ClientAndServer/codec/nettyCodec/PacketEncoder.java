package com.ycw.im.ClientAndServer.codec.nettyCodec;

import com.ycw.im.ClientAndServer.codec.Codec;
import com.ycw.im.ClientAndServer.protocol.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;


public class PacketEncoder extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf out) {
        Codec.INSTANCE.encode(out,packet);
    }
}
