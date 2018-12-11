package com.ycw.wechat.service;

import com.ycw.wechat.pojo.Users;
import com.ycw.wechat.utils.DataResult;

public interface UserService {
    DataResult queryUsername(String username);
    DataResult registor(String username,String password);
    DataResult login(String username,String password);
}
