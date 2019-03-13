package com.ycw.im.imdistributedserver.service;

import com.ycw.im.imdistributedcom.pojo.ChatMsg;
import com.ycw.im.imdistributedcom.protocol.RequestProtocol;
import com.ycw.im.imdistributedserver.dao.ChatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yuchunwei
 */
@Service
public class ChatService {
    @Autowired
    private ChatDao chatDao;

    public void insertMsg(RequestProtocol.ReqProtocol protocol){
        ChatMsg chatMsg = new ChatMsg(String.valueOf(protocol.getSendId()),String.valueOf(protocol.getRequestId()),protocol.getReqMsg());
        chatDao.insertMsg(chatMsg);
    }
}   
