package com.ycw.Mobilewechat.netty.strategy.impl;

import com.ycw.Mobilewechat.netty.UserChannels;
import com.ycw.Mobilewechat.netty.pojo.ChatMsgVo;
import com.ycw.Mobilewechat.netty.pojo.DataContent;
import com.ycw.Mobilewechat.netty.strategy.Strategy;
import io.netty.channel.Channel;

/**
 * @Author yuchunwei
 */
public class ConnectStrategy implements Strategy {

    @Override
    public void handle(DataContent dataContent , Channel curChannel) {
        ChatMsgVo chatMsgVo = dataContent.getChatMsgVo();
        UserChannels.put(dataContent.getChatMsgVo().getSenderId(),curChannel);
    }
}
