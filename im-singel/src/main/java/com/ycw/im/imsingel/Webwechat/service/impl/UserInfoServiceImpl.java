package com.ycw.im.imsingel.Webwechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ycw.im.imsingel.Webwechat.dao.UserInfoDao;
import com.ycw.im.imsingel.Webwechat.model.po.UserInfo;
import com.ycw.im.imsingel.Webwechat.model.vo.ResponseJson;
import com.ycw.im.imsingel.Webwechat.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public ResponseJson getByUserId(String userId) {
        UserInfo userInfo = userInfoDao.getByUserId(userId);
        return new ResponseJson().success()
                .setData("userInfo", userInfo);
    }

}
