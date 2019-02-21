package com.ycw.Mobilewechat.pojo.bo;

import com.ycw.Mobilewechat.enums.AddFriendRequstEnum;
import lombok.Data;

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
