package com.ycw.im.imsingel.Webwechat.service;

import com.ycw.im.imsingel.Webwechat.model.vo.ResponseJson;

import javax.servlet.http.HttpSession;

public interface SecurityService {

    ResponseJson login(String username, String password, HttpSession session);
    
    ResponseJson logout(HttpSession session);
}
