package com.ycw.wechat.service;

import com.ycw.wechat.pojo.ChatMsg;
import com.ycw.wechat.pojo.DataResult;

import java.util.List;

public interface ChatService {
     int insertMsg(ChatMsg msg);

     DataResult queryUnSignMsgs(String accpetId);

     void updateMsgToSign(List<String> ids);

}
