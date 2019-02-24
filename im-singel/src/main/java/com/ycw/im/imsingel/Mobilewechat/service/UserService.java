package com.ycw.im.imsingel.Mobilewechat.service;

import com.ycw.im.imsingel.Mobilewechat.pojo.Users;
import com.ycw.im.imsingel.Mobilewechat.pojo.DataResult;
import com.ycw.im.imsingel.Mobilewechat.pojo.bo.AddFriendRequst;
import com.ycw.im.imsingel.Mobilewechat.pojo.bo.UserBo;

public interface UserService {
    DataResult queryUsername(String username);

    DataResult registor(String username, String password);

    DataResult login(Users users);

    DataResult upLoadImage(UserBo userBo);

    DataResult setNickName(UserBo userBo);

    DataResult searchFriend(AddFriendRequst requst);


}
