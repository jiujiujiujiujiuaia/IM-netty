package com.ycw.Mobilewechat.mapper;

import com.ycw.Mobilewechat.utils.MyMapper;
import com.ycw.Mobilewechat.pojo.ChatMsg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMsgMapper extends MyMapper<ChatMsg> {
    int insertMsg(ChatMsg chatMsg);

    List<ChatMsg> queryUnSignMsgs(@Param("acceptUserId") String acceptUserId);

    void updateMsgToSign(List<String> ids);
}