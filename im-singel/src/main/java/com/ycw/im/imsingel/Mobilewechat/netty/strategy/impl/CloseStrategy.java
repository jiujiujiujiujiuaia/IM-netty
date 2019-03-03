package com.ycw.im.imsingel.Mobilewechat.netty.strategy.impl;

import com.ycw.im.imsingel.Mobilewechat.netty.UserChannels;
import com.ycw.im.imsingel.Mobilewechat.netty.pojo.DataContent;
import com.ycw.im.imsingel.Mobilewechat.netty.strategy.Strategy;
import io.netty.channel.Channel;

/**
 * @Author yuchunwei
 */
public class CloseStrategy implements Strategy {

    @Override
    public void handle(DataContent dataContent, Channel curChannel) {
        UserChannels.put(dataContent.getExtand(), null);
        System.out.println("用户" + dataContent.getExtand() + "被移除");
    }
}
