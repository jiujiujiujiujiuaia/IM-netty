package com.ycw.im.Learn.util;

public enum Command {
    LoginRequest(0x001),
    LoginRespose(0x002),
    MessageRequest(0x003),
    MessageResponse(0x004);

    private int code;
    private Command(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }
}
