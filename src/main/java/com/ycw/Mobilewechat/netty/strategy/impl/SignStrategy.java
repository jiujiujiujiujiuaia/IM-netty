package com.ycw.Mobilewechat.netty.strategy.impl;

import com.ycw.Mobilewechat.netty.pojo.DataContent;
import com.ycw.Mobilewechat.netty.strategy.Strategy;
import com.ycw.Mobilewechat.service.ChatService;
import com.ycw.Mobilewechat.utils.SpringUtil;
import io.netty.channel.Channel;

import java.util.Arrays;
import java.util.List;

/**
 * @Author yuchunwei
 */
public class SignStrategy implements Strategy {


    @Override
    public void handle(DataContent dataContent, Channel curChannel) {
        String unSignedMsgIdStr = dataContent.getExtand();
        List<String> unSignedMsgIds = Arrays.asList(unSignedMsgIdStr.split(","));
        //应该检测一下是否是数字的
        if(unSignedMsgIds.size() > 0) {
            ChatService chatService = (ChatService)SpringUtil.getBean("chatServiceImpl");
            chatService.updateMsgToSign(unSignedMsgIds);
        }
        }
}
