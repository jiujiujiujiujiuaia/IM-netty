package com.ycw.im.imsingel.Mobilewechat.netty.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author yuchunwei
 */
@Data
public class DataContent {
    private static final long serialVersionUID = 8021381444738260454L;

    private Integer action;        // 动作类型
    @JsonProperty(value = "ChatMsgVo")
    private ChatMsgVo chatMsgVo;    // 用户的聊天内容entity
    private String extand;        // 扩展字段
}
