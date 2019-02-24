package com.ycw.im.imsingel.Mobilewechat.netty.strategy;

import com.ycw.im.imsingel.Mobilewechat.netty.pojo.DataContent;
import io.netty.channel.Channel;

public interface Strategy {

    public void handle(DataContent dataContent, Channel curChannel);
}
