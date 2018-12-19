package com.ycw.learnNettyExample.ClientAndServer.protocol.response;

import com.ycw.learnNettyExample.ClientAndServer.protocol.Packet;
import com.ycw.learnNettyExample.ClientAndServer.util.Command;
import lombok.Data;

@Data
public class LoginResponse extends Packet {
    private boolean isSuccess;
    private String message;
    private String userName;

    public Integer getCommand(){
        return Command.LoginRespose.getCode();
    }
}
