package com.ycw.im.imdistributedserver.server;

import com.ycw.im.imdistributedcom.constant.Constants;
import com.ycw.im.imdistributedcom.protocol.RequestProtocol;
import com.ycw.im.imdistributedserver.init.ServerNettyInit;
import com.ycw.im.imdistributedserver.util.SessionChannelHolder;
import com.ycw.im.imdistributedserver.vo.request.SendMsgReqVo;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;

/**
 * @Author yuchunwei
 */
@Component
public class Server {
    private final static Logger LOGGER = LoggerFactory.getLogger(Server.class);

    private EventLoopGroup boss = new NioEventLoopGroup();
    private EventLoopGroup work = new NioEventLoopGroup();

    @Value("${im.server.port}")
    private int port;


    @PostConstruct
    public void start() throws Exception{
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                .group(boss,work)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(port))
                .childOption(ChannelOption.SO_KEEPALIVE,true)
                .childHandler(new ServerNettyInit());
        ChannelFuture future = serverBootstrap.bind().sync();
        if(future.isSuccess()){
            LOGGER.info("netty服务端程序已启动"  + "端口为" + port );
        }
    }

    @PreDestroy
    public void destroy(){
        boss.shutdownGracefully().syncUninterruptibly();
        work.shutdownGracefully().syncUninterruptibly();
        LOGGER.info("服务端程序已经关闭");
    }

    //转发消息方法
    public void sendMsg(SendMsgReqVo reqVo){
        NioSocketChannel channel = SessionChannelHolder.getChannel(reqVo.getUserId());
        if(channel == null){
            throw  new NullPointerException("用户[" + reqVo.getUserId() +"]没有上线");
        }
        RequestProtocol.ReqProtocol protocol = RequestProtocol.ReqProtocol.newBuilder()
                .setReqMsg(reqVo.getMsg())
                .setType(Constants.CommandType.MSG)
                .setRequestId(reqVo.getUserId())
                .build();
        ChannelFuture future = channel.writeAndFlush(protocol);
        future.addListener((ChannelFutureListener)channelFuture ->
            LOGGER.info("服务端转发Goolgel protocol 成功 ：{}" , reqVo.toString())
        );
    }

}   
