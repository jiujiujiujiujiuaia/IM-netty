package com.ycw.im.ClientAndServer.protocol.request;

import com.ycw.im.ClientAndServer.protocol.Packet;
import com.ycw.im.ClientAndServer.util.Command;
import lombok.Data;

@Data
public class LoginRequest extends Packet {
    private String username;
    private String password;

    public Integer getCommand(){
        return Command.LoginRequest.getCode();
    }

}
