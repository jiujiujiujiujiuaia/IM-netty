package com.ycw.im.imsingel.Mobilewechat.netty.strategy.impl;

import com.ycw.im.imsingel.Mobilewechat.netty.UserChannels;
import com.ycw.im.imsingel.Mobilewechat.netty.pojo.ChatMsgVo;
import com.ycw.im.imsingel.Mobilewechat.netty.pojo.DataContent;
import com.ycw.im.imsingel.Mobilewechat.netty.strategy.Strategy;
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
