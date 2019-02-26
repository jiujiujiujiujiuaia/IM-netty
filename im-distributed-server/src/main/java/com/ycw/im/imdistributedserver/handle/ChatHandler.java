package com.ycw.im.imdistributedserver.handle;

import com.ycw.im.imdistributedcom.constant.Constants;
import com.ycw.im.imdistributedcom.protocol.RequestProtocol;
import com.ycw.im.imdistributedcom.util.NettyAttrUtil;
import com.ycw.im.imdistributedserver.util.SessionChannelHolder;
import com.ycw.im.imdistributedserver.util.SpringFactory;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author yuchunwei
 */
@ChannelHandler.Sharable
public class ChatHandler extends SimpleChannelInboundHandler<RequestProtocol.ReqProtocol> {

    private final static Logger LOGGER = LoggerFactory.getLogger(ChatHandler.class);


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RequestProtocol.ReqProtocol msg) throws Exception {
        LOGGER.info("服务端收到消息" + msg.getReqMsg());

        //登陆请求
        if(msg.getType() == Constants.CommandType.LOGIN){
            SessionChannelHolder.saveSession(msg.getRequestId(),msg.getReqMsg());
            SessionChannelHolder.putChannel(msg.getRequestId(),(NioSocketChannel)ctx.channel());
            LOGGER.info("客户端[{}]上线",msg.getReqMsg());
        }

        //心跳检测请求
        if(msg.getType() == Constants.CommandType.PING){
            NettyAttrUtil.updateReaderTime(ctx.channel(),System.currentTimeMillis());
            RequestProtocol.ReqProtocol heartbeat = SpringFactory.getBean("heartbeat",RequestProtocol.ReqProtocol.class);
            ctx.writeAndFlush(heartbeat).addListener((ChannelFutureListener) future -> {
                if(!future.isSuccess()){
                    LOGGER.error("心跳检测回包错误");
                    future.channel().close();
                }
            });
        }


    }
}
