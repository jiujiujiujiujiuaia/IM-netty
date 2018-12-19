package com.ycw.learnNettyExample.ClientAndServer.protocol.request;

import com.ycw.learnNettyExample.ClientAndServer.protocol.Packet;
import com.ycw.learnNettyExample.ClientAndServer.util.Command;
import lombok.Data;

@Data
public class LoginRequest extends Packet {
    private String username;
    private String password;

    public Integer getCommand(){
        return Command.LoginRequest.getCode();
    }

}
