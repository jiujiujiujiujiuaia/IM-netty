package com.ycw.im.imsingel.Mobilewechat.mapper;

import com.ycw.im.imsingel.Mobilewechat.pojo.ChatMsg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMsgMapper {
    int insertMsg(ChatMsg chatMsg);

    List<ChatMsg> queryUnSignMsgs(@Param("acceptUserId") String acceptUserId);

    void updateMsgToSign(List<String> ids);
}