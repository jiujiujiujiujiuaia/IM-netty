package com.ycw.Mobilewechat.netty.strategy.impl;

import com.ycw.Mobilewechat.netty.pojo.DataContent;
import com.ycw.Mobilewechat.netty.strategy.Strategy;
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
