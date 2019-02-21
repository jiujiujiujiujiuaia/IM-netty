package com.ycw.Mobilewechat.enums;

/**
 * @Author yuchunwei
 */
//无论添加好友的请求是成功还是忽略 都是已经处理的状态
public enum AddFriendRequstEnum {
    HANDLED(1,"已经处理"),
    UNHANDLED(2,"还没有被处理"),
    ISYOURFRIEND(3,"已经是你的好友，无法添加"),
    ISYOURSELF(4,"无法添加自己");

    private int code;
    private String message;
    AddFriendRequstEnum(int code,String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
