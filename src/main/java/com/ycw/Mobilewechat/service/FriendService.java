package com.ycw.Mobilewechat.service;

import com.ycw.Mobilewechat.pojo.DataResult;
import com.ycw.Mobilewechat.pojo.bo.AddFriendRequst;
import com.ycw.Mobilewechat.pojo.bo.HandleFriendRequest;

/**
 * @Author yuchunwei
 */
public interface FriendService {
    DataResult addFriend(AddFriendRequst requst);

    DataResult queryFriendRequest(String userId);

    DataResult operFriendRequest(HandleFriendRequest request);

    DataResult getAllFriend(String userId);
}
