package com.ycw.im.imsingel.Mobilewechat.netty.strategy.impl;

import com.ycw.im.imsingel.Mobilewechat.netty.UserChannels;
import com.ycw.im.imsingel.Mobilewechat.netty.pojo.ChatMsgVo;
import com.ycw.im.imsingel.Mobilewechat.netty.pojo.DataContent;
import com.ycw.im.imsingel.Mobilewechat.netty.strategy.Strategy;
import com.ycw.im.imsingel.Mobilewechat.pojo.ChatMsg;
import com.ycw.im.imsingel.Mobilewechat.service.ChatService;
import com.ycw.im.imsingel.Mobilewechat.utils.JsonUtils;
import com.ycw.im.imsingel.Mobilewechat.utils.SpringUtil;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.util.Date;

/**
 * @Author yuchunwei
 */
public class ChatStrategy implements Strategy {
    @Override
    public void handle(DataContent dataContent, Channel curChannel) {
        ChatMsgVo chatMsgVo = dataContent.getChatMsgVo();
        ChatMsg chatMsg = new ChatMsg();
        String msgText = chatMsgVo.getMsg();
        String receiverId = chatMsgVo.getReceiverId();
        String senderId = chatMsgVo.getSenderId();


        chatMsg.setAcceptUserId(receiverId);
        chatMsg.setSendUserId(senderId);
        chatMsg.setMsg(msgText);
        chatMsg.setCreateTime(new Date());
        //签收flag 0 -> 未签收 1 -> 已签收
        chatMsg.setSignFlag(0);
        ChatService chatService = (ChatService) SpringUtil.getBean("chatServiceImpl");
        int msgId = chatService.insertMsg(chatMsg);
        chatMsgVo.setMsgId(String.valueOf(msgId));
        Channel receiveChannel = UserChannels.get(senderId);
        if (receiveChannel != null) {
            receiveChannel.writeAndFlush(new TextWebSocketFrame(JsonUtils.objectToJson(chatMsgVo)));
        }
    }
}
