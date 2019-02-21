package com.ycw.Webwechat.service;

import com.ycw.Webwechat.model.vo.ResponseJson;

public interface UserInfoService {

    ResponseJson getByUserId(String userId);
}
