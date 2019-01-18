package com.ycw.wechat.mapper;

import com.ycw.wechat.utils.MyMapper;
import com.ycw.wechat.pojo.ChatMsg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMsgMapper extends MyMapper<ChatMsg> {
    int insertMsg(ChatMsg chatMsg);

    List<ChatMsg> getUnReadMsgList(@Param("id") String acceptUserId);
}