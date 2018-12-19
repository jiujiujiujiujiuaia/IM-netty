package com.ycw.wechat.service;

import com.ycw.wechat.pojo.Users;
import com.ycw.wechat.pojo.DataResult;

public interface UserService {
    DataResult queryUsername(String username);
    DataResult registor(String username,String password);
    DataResult login(Users users);
}
