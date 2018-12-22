package com.ycw.wechat.pojo.bo;

import com.ycw.wechat.enums.AddFriendRequstEnum;
import lombok.Data;

import javax.annotation.security.DenyAll;
import java.util.Date;

/**
 * @Author yuchunwei
 */
@Data
public class AddFriendRequst {
    private String myUserId;
    private String friendUsername;
    private String friendId;
    private String date;
    private int status = AddFriendRequstEnum.UNHANDLED.getCode();
}   
