package com.ycw.im.imsingel.Webwechat.dao;

import com.ycw.im.imsingel.Webwechat.model.po.UserInfo;

public interface UserInfoDao {

    void loadUserInfo();

    UserInfo getByUsername(String username);

    UserInfo getByUserId(String userId);
}
