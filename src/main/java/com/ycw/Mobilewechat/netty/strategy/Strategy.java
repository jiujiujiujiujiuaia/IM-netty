package com.ycw.Mobilewechat.netty.strategy;

import com.ycw.Mobilewechat.netty.pojo.DataContent;
import io.netty.channel.Channel;

public interface Strategy {

    public void handle(DataContent dataContent ,Channel curChannel);
}
