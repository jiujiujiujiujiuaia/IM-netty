package com.ycw.im.ClientAndServer.util;

import io.netty.channel.Channel;

public class LoginUtil {
    public static void set(Channel channel){
        channel.attr(State.LOGIN).set(true);
    }
    public static boolean isLogin(Channel channel){
        return channel.hasAttr(State.LOGIN);
    }
    public static String getUserName(Channel channel){
        return channel.attr(State.USERNAME).get();
    }
    public static void setUserName(Channel channel,String id){
        channel.attr(State.USERNAME).set(id);
    }
}
