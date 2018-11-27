package com.ycw.im.Learn.protocol.response;

import com.ycw.im.Learn.protocol.Packet;
import com.ycw.im.Learn.util.Command;
import lombok.Data;

@Data
public class LoginResponse extends Packet {
    private boolean isSuccess;
    private String message;
    private String id;

    public Integer getCommand(){
        return Command.LoginRespose.getCode();
    }
}
