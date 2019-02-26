package com.ycw.im.imdistributedserver.init;

import com.ycw.im.imdistributedcom.protocol.RequestProtocol;
import com.ycw.im.imdistributedserver.handle.ChatHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * @Author yuchunwei
 */
public class ServerNettyInit extends ChannelInitializer<Channel> {
    @Override
    protected void initChannel(Channel channel) throws Exception {

        channel.pipeline()
                 .addLast(new IdleStateHandler(11, 0, 0))
                // google Protobuf 编解码
                .addLast(new ProtobufVarint32FrameDecoder())
                .addLast(new ProtobufDecoder(RequestProtocol.ReqProtocol.getDefaultInstance()))
                .addLast(new ProtobufVarint32LengthFieldPrepender())
                .addLast(new ProtobufEncoder())
                .addLast(new ChatHandler());
    }

    public static void main(String[] args) {

    }
}   
