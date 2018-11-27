package com.ycw.im.Learn.util;

import io.netty.channel.Channel;

public class LoginUtil {
    public static void set(Channel channel){
        channel.attr(State.LOGIN).set(true);
    }
    public static boolean isLogin(Channel channel){
        return channel.hasAttr(State.LOGIN);
    }
    public static String getId(Channel channel){
        return channel.attr(State.ID).get();
    }
    public static void setId(Channel channel,String id){
        channel.attr(State.ID).set(id);
    }
}
