package com.ycw.im.imsingel.Webwechat.web.controller;

import com.ycw.im.imsingel.Mobilewechat.controller.UserController;
import com.ycw.im.imsingel.Mobilewechat.pojo.DataResult;
import com.ycw.im.imsingel.Mobilewechat.pojo.Users;
import com.ycw.im.imsingel.Mobilewechat.service.UserService;
import com.ycw.im.imsingel.Webwechat.service.impl.SecurityServiceImpl;
import com.ycw.im.imsingel.Webwechat.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.ycw.im.imsingel.Webwechat.model.vo.ResponseJson;
import com.ycw.im.imsingel.Webwechat.service.SecurityService;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.MessageFormat;

@Controller
@RestController
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;
    
    @RequestMapping(value = {"login", "/"}, method = RequestMethod.GET)
    public ModelAndView toLogin() {
        return new ModelAndView("login.html");
    }

    @PostMapping("/login")
    @ResponseBody
    public DataResult login(HttpSession session, Users users) {
        if(UserController.isVaild(users.getUsername(),users.getPassword())){
            return DataResult.errorMsg("密码或者用户名不能为空");
        }
        DataResult result = userService.login(users);
        if(result.getStatus() == 200){
            session.setAttribute(Constant.USER_TOKEN, users.getId());
        }
        return result;
    }

    @PostMapping("/logout")
    @ResponseBody
    public DataResult logout(HttpSession session) {
        Object userId = session.getAttribute(Constant.USER_TOKEN);
        if (userId == null) {
            return  DataResult.errorMsg("请先登陆");
        }
        session.removeAttribute(Constant.USER_TOKEN);
        LOGGER.info(MessageFormat.format("userId为 {0} 的用户已注销登录!", userId));
        return DataResult.ok();
    }
}
