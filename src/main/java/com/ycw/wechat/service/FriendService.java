package com.ycw.wechat.service;

import com.ycw.wechat.pojo.DataResult;
import com.ycw.wechat.pojo.bo.AddFriendRequst;

/**
 * @Author yuchunwei
 */
public interface FriendService {
    DataResult addFriend(AddFriendRequst requst);
}   
