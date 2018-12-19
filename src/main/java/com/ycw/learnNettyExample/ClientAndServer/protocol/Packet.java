package com.ycw.learnNettyExample.ClientAndServer.protocol;

import com.ycw.learnNettyExample.ClientAndServer.util.Command;

public abstract class Packet {
    private Command command;

    public abstract Object getCommand();
}
