package com.ycw.wechat.netty.strategy;

import com.ycw.wechat.netty.pojo.DataContent;
import io.netty.channel.Channel;

public interface Strategy {

    public void handle(DataContent dataContent ,Channel curChannel);
}
