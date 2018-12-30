package com.ycw.wechat.service;

import com.ycw.wechat.pojo.DataResult;
import com.ycw.wechat.pojo.bo.AddFriendRequst;
import com.ycw.wechat.pojo.bo.HandleFriendRequest;

/**
 * @Author yuchunwei
 */
public interface FriendService {
    DataResult addFriend(AddFriendRequst requst);

    DataResult queryFriendRequest(String userId);

    DataResult operFriendRequest(HandleFriendRequest request);

    DataResult getAllFriend(String userId);
}
