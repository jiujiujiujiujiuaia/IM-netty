package com.ycw.Mobilewechat.service;

import com.ycw.Mobilewechat.pojo.ChatMsg;
import com.ycw.Mobilewechat.pojo.DataResult;

import java.util.List;

public interface ChatService {
     int insertMsg(ChatMsg msg);

     DataResult queryUnSignMsgs(String accpetId);

     void updateMsgToSign(List<String> ids);

}
