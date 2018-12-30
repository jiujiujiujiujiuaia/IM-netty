package com.ycw.wechat.pojo.bo;

import lombok.Data;

/**
 * @Author yuchunwei
 */
@Data
public class HandleFriendRequest {
    private String acceptUserId;
    private String sendUserId;
    private String operType;
    private int status;
}
