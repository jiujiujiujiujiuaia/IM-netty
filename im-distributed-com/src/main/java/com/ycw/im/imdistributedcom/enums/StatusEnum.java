package com.ycw.im.imdistributedcom.enums;

/**
 * @Author yuchunwei
 */
public enum StatusEnum {


    SUCCESS(200, "成功"),
    FAIL(-1, "失败"),

    //消息相关
    SEND_SUCCESS(300,"发送消息成功"),
    SEND_FAIL(301,"发送消息失败"),


    //登陆相关400起始
    LOGIN_SUCCESS(400,"登陆成功"),
    REPEAT_LOGIN(401, "重复登陆"),
    OFF_LINE(402, "用户下线"),

    //注册相关500起始
    REGISTOR_SUCCESS(500,"注册成功"),
    REPEAT_USERNAME(501,"注册失败，username重复"),
    REPEAT_USERID(502,"注册失败，userid重复"),
    NOTREGISTOR(503,"没有注册");

    private int code;
    private String description;

    StatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}   
