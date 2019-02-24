package com.ycw.im.imsingel.learnNettyExample.ClientAndServer.protocol;

import com.ycw.im.imsingel.learnNettyExample.ClientAndServer.util.Command;

public abstract class Packet {
    private Command command;

    public abstract Object getCommand();
}
