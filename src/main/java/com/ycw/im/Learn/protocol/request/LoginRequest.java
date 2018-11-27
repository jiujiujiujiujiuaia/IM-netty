package com.ycw.im.Learn.protocol.request;

import com.ycw.im.Learn.protocol.Packet;
import com.ycw.im.Learn.util.Command;
import lombok.Data;

@Data
public class LoginRequest extends Packet {
    private String username;
    private String password;

    public Integer getCommand(){
        return Command.LoginRequest.getCode();
    }

}
