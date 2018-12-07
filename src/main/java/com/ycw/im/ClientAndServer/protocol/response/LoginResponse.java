package com.ycw.im.ClientAndServer.protocol.response;

import com.ycw.im.ClientAndServer.protocol.Packet;
import com.ycw.im.ClientAndServer.util.Command;
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
