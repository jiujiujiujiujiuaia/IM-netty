package com.ycw.learnNettyExample.ClientAndServer.protocol.request;

import com.ycw.learnNettyExample.ClientAndServer.protocol.Packet;
import com.ycw.learnNettyExample.ClientAndServer.util.Command;
import lombok.Data;

@Data
public class MessageRequest extends Packet {
    private String message;
    private String toUserName;
    private String fromUsername;

    public MessageRequest(){

    }

    public MessageRequest(String message,String toUserName,String fromUsername){
        this.message = message;
        this.toUserName = toUserName;
        this.fromUsername = fromUsername;
    }

    public Integer getCommand(){
        return Command.MessageRequest.getCode();
    }
}
