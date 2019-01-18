package com.ycw.wechat.netty.strategy.impl;

import com.ycw.wechat.netty.UserChannels;
import com.ycw.wechat.netty.pojo.ChatMsgVo;
import com.ycw.wechat.netty.pojo.DataContent;
import com.ycw.wechat.netty.strategy.Strategy;
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
