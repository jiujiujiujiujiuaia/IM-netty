package com.ycw.im.imdistributedcom.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class ChatMsg {
    public ChatMsg(String sendUserId,String acceptUserId,String msg){
        this.sendUserId = sendUserId;
        this.acceptUserId = acceptUserId;
        this.msg = msg;
        this.createTime = new Date();
        this.signFlag = 1;
    }

    private String id;

    private String sendUserId;

    private String acceptUserId;

    private String msg;

    private Integer signFlag;

    private Date createTime;

}