package com.ycw.im.ClientAndServer.protocol;

import com.ycw.im.ClientAndServer.util.Command;

public abstract class Packet {
    private Command command;

    public abstract Object getCommand();
}
