package com.ycw.im.imsingel.Mobilewechat.enums;

public enum MsgStateEnum {
    CONNECT(1," 第一次(或重连)初始化连接"),
    CHAT(2,"聊天消息") 	,
    SIGNED(3,"消息签收") ,
    KEEPALIVE(4,"客户端保持心跳"),
    PULL_FRIEND(5,"重新拉取好友"),
    CLOSE(6,"close")
    ;
    private Integer code;
    private String des ;
    MsgStateEnum(Integer code,String des){
        this.code  = code;
        this.des = des ;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDes() {
        return des;
    }
}
