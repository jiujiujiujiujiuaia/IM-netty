package com.ycw.wechat.service;

import com.ycw.wechat.pojo.ChatMsg;
import com.ycw.wechat.pojo.DataResult;

public interface ChatService {
     int insertMsg(ChatMsg msg);

     DataResult queryUnReadMsgs(String  accpetId);
}
