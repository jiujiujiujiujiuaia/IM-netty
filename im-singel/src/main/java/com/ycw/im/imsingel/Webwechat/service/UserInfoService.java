package com.ycw.im.imsingel.Webwechat.service;

import com.ycw.im.imsingel.Webwechat.model.vo.ResponseJson;

public interface UserInfoService {

    ResponseJson getByUserId(String userId);
}
