package com.ycw.im.imsingel.Mobilewechat.netty.strategy;

import com.ycw.im.imsingel.Mobilewechat.netty.pojo.DataContent;
import io.netty.channel.Channel;

/**
 * @Author yuchunwei
 */
public class Context {
    private Strategy strategy;

    public static void handle(DataContent dataContent, Channel curChannel) {
        Strategy strategy = StrategyFactory.getInstance().create(dataContent.getAction());
        strategy.handle(dataContent, curChannel);
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
