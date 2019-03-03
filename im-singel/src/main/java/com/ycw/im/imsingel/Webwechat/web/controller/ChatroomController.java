package com.ycw.im.imsingel.Webwechat.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ycw.im.imsingel.Webwechat.model.vo.ResponseJson;
import com.ycw.im.imsingel.Webwechat.service.UserInfoService;
import com.ycw.im.imsingel.Webwechat.util.Constant;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class ChatroomController {

    @Autowired
    UserInfoService userInfoService;

    /**
     * 描述：登录成功后，调用此接口进行页面跳转
     *
     * @return
     */
    @RequestMapping(value = "/chatroom")
    public ModelAndView toChatroom(HttpSession session) {
        Object userId = session.getAttribute(Constant.USER_TOKEN);
        if (userId == null) return new ModelAndView("login.html");
        return new ModelAndView("chatroom.html");
    }

    /**
     * 描述：登录成功跳转页面后，调用此接口获取用户信息
     *
     * @return
     */
    @RequestMapping(value = "/chatroom/get_userinfo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson getUserInfo(HttpSession session) {
        Object userId = session.getAttribute(Constant.USER_TOKEN);
        return userInfoService.getByUserId((String) userId);
    }
}
