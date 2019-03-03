package com.ycw.im.imsingel.Mobilewechat.controller;

import com.ycw.im.imsingel.Mobilewechat.pojo.DataResult;
import com.ycw.im.imsingel.Mobilewechat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yuchunwei
 */
@RestController
@RequestMapping("/c")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @RequestMapping("/getUnSignMsgs")
    public DataResult getUnSignMsgs(String acceptUserId) {
        return chatService.queryUnSignMsgs(acceptUserId);
    }

}   
