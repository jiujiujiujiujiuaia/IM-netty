package com.ycw.wechat.netty.strategy.impl;

import com.ycw.wechat.netty.pojo.DataContent;
import com.ycw.wechat.netty.strategy.Strategy;
import io.netty.channel.Channel;

/**
 * @Author yuchunwei
 */
public class HeartCheckStrategy implements Strategy {



    @Override
    public void handle(DataContent dataContent, Channel curChannel) {
        System.out.println("收到心跳检查");
    }
}
