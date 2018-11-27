package com.ycw.im.Learn.protocol;

import com.ycw.im.Learn.util.Command;

public abstract class Packet {
    private Command command;

    public abstract Object getCommand();
}
