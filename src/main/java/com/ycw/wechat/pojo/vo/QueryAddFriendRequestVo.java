package com.ycw.wechat.pojo.vo;

import lombok.Data;

import javax.annotation.security.DenyAll;

/**
 * @Author yuchunwei
 */
@Data
public class QueryAddFriendRequestVo {
    private String sendUserId;
    private String sendNickname;
    private String sendFaceImage;
}
