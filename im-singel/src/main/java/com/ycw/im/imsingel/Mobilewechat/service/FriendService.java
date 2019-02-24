package com.ycw.im.imsingel.Mobilewechat.service;

import com.ycw.im.imsingel.Mobilewechat.pojo.DataResult;
import com.ycw.im.imsingel.Mobilewechat.pojo.bo.AddFriendRequst;
import com.ycw.im.imsingel.Mobilewechat.pojo.bo.HandleFriendRequest;

/**
 * @Author yuchunwei
 */
public interface FriendService {
    DataResult addFriend(AddFriendRequst requst);

    DataResult queryFriendRequest(String userId);

    DataResult operFriendRequest(HandleFriendRequest request);

    DataResult getAllFriend(String userId);
}
