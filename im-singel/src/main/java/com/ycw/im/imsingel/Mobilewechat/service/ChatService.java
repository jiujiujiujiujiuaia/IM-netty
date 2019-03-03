package com.ycw.im.imsingel.Mobilewechat.service;

import com.ycw.im.imsingel.Mobilewechat.pojo.ChatMsg;
import com.ycw.im.imsingel.Mobilewechat.pojo.DataResult;

import java.util.List;

public interface ChatService {
    int insertMsg(ChatMsg msg);

    DataResult queryUnSignMsgs(String accpetId);

    void updateMsgToSign(List<String> ids);

}
