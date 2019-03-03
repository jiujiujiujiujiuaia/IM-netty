package com.ycw.im.imsingel.learnNettyExample.ClientAndServer.protocol.response;

import com.ycw.im.imsingel.learnNettyExample.ClientAndServer.protocol.Packet;
import com.ycw.im.imsingel.learnNettyExample.ClientAndServer.util.Command;
import lombok.Data;

@Data
public class MessageResponse extends Packet {
    private String message;
    private String toUserName;
    private String fromUserName;
    private boolean isUp;

    public Integer getCommand() {
        return Command.MessageResponse.getCode();
    }
}
