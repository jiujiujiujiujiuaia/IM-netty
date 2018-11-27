package com.ycw.im.Learn.protocol.response;

import com.ycw.im.Learn.protocol.Packet;
import com.ycw.im.Learn.util.Command;
import lombok.Data;

@Data
public class MessageResponse extends Packet {
    private String message;
    private String username;
    private String userId;
    private boolean isUp;

    public Integer getCommand(){
        return Command.MessageResponse.getCode();
    }
}
