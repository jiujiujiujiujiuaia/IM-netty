package com.ycw.im.Learn.client;


import com.ycw.im.Learn.client.handler.LoginResponseHandler;
import com.ycw.im.Learn.client.handler.MessageResponseHandler;
import com.ycw.im.Learn.codec.nettyCodec.PacketDecoder;
import com.ycw.im.Learn.codec.nettyCodec.PacketEncoder;
import com.ycw.im.Learn.protocol.request.LoginRequest;
import com.ycw.im.Learn.protocol.request.MessageRequest;
import com.ycw.im.Learn.util.LoginUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;
import java.util.Scanner;


public class NettyClient {
    public static void init(){
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap
                .group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel sc){
                        sc.pipeline().addLast(new PacketDecoder());
                        sc.pipeline().addLast(new LoginResponseHandler());
                        sc.pipeline().addLast(new MessageResponseHandler());
                        sc.pipeline().addLast(new PacketEncoder());
                    }
                });
        connect(bootstrap,"127.0.0.1",6666,10);
    }
    private static void connect(Bootstrap bootstrap, String host, int port, int retry) {
        bootstrap.connect(host, port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println(new Date() + ": 连接成功，启动控制台线程");
                Channel channel = ((ChannelFuture) future).channel();
                startConsoleThread(channel);
            }
        });
    }
    private static void startConsoleThread(Channel channel) {
        Scanner sc = new Scanner(System.in);
        LoginRequest request = new LoginRequest();
        new Thread(() ->{
            while (!Thread.interrupted()){
                if(!LoginUtil.isLogin(channel)) {
                    System.out.println("请输入您的用户名");
                    request.setUsername(sc.nextLine());
                    channel.writeAndFlush(request);
                    try{
                        Thread.sleep(1000);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else {
                    System.out.println("请输入消息");
                    String username = sc.nextLine();
                    MessageRequest messageRequest = new MessageRequest(username.split(" ")[1],username.split(" ")[0],LoginUtil.getId(channel));
                    channel.writeAndFlush(messageRequest);
                }
            }
        }).start();
    }
    public static void main(String[] args){
        init();
    }
}
