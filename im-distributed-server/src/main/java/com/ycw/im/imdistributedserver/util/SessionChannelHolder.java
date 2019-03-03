package com.ycw.im.imdistributedserver.util;


import com.ycw.im.imdistributedcom.pojo.UserInfo;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author yuchunwei
 */
public class SessionChannelHolder {
    private final static Map<Long, NioSocketChannel> channelMap = new ConcurrentHashMap<>(16);
    private final static Map<Long, String> SessionMap = new ConcurrentHashMap<>(16);

    //保存用户及用户名
    public static void saveSession(Long userId, String userName) {
        SessionMap.put(userId, userName);
    }

    public static void removeSession(Long userId) {
        SessionMap.remove(userId);
    }

    //保存在线channel及删除
    public static void putChannel(Long userId, NioSocketChannel channel) {
        channelMap.put(userId, channel);
    }

    public static NioSocketChannel getChannel(Long userId) {
        return channelMap.get(userId);
    }

    public static void removeChannel(NioSocketChannel channel) {
        channelMap.entrySet().stream().filter(entry -> entry.getValue() == channel).forEach(entry -> channelMap.remove(entry.getKey()));
    }

    public static Map getChannelMap() {
        return channelMap;
    }

    //通过channel获取用户信息
    public static UserInfo getUserInfo(NioSocketChannel channel) {
        for (Map.Entry<Long, NioSocketChannel> map : channelMap.entrySet()) {
            if (map.getValue() == channel) {
                Long userId = map.getKey();
                String userName = SessionMap.get(userId);
                UserInfo userInfo = new UserInfo(userId, userName);
                return userInfo;
            }
        }
        return null;
    }


}
