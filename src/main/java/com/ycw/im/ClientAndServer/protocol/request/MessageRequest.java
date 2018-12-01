package com.ycw.im.ClientAndServer.protocol.request;

import com.ycw.im.ClientAndServer.protocol.Packet;
import com.ycw.im.ClientAndServer.util.Command;
import lombok.Data;

@Data
public class MessageRequest extends Packet {
    private String message;
    private String username;
    private String userId;

    public MessageRequest(){

    }

    public MessageRequest(String message,String username,String userId){
        this.message = message;
        this.username = username;
        this.userId = userId;
    }

    public Integer getCommand(){
        return Command.MessageRequest.getCode();
    }
}
