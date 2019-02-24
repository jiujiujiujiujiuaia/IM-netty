package com.ycw.im.imsingel.learnNettyExample.ClientAndServer.protocol.request;

import com.ycw.im.imsingel.learnNettyExample.ClientAndServer.protocol.Packet;
import com.ycw.im.imsingel.learnNettyExample.ClientAndServer.util.Command;
import lombok.Data;

@Data
public class LoginRequest extends Packet {
    private String username;
    private String password;

    public Integer getCommand(){
        return Command.LoginRequest.getCode();
    }

}
