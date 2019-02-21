package com.ycw.Webwechat.dao;

import com.ycw.Webwechat.model.po.UserInfo;

public interface UserInfoDao {

    void loadUserInfo();
    
    UserInfo getByUsername(String username);
    
    UserInfo getByUserId(String userId);
}
