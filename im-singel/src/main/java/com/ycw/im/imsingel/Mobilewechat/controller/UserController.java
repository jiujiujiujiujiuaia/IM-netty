package com.ycw.im.imsingel.Mobilewechat.controller;

import com.ycw.im.imsingel.Mobilewechat.pojo.Users;
import com.ycw.im.imsingel.Mobilewechat.pojo.bo.AddFriendRequst;
import com.ycw.im.imsingel.Mobilewechat.pojo.bo.UserBo;
import com.ycw.im.imsingel.Mobilewechat.service.UserService;
import com.ycw.im.imsingel.Mobilewechat.pojo.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author yuchunwei
 */
@RestController
@RequestMapping("/u")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public DataResult login(@RequestBody Users users) {
        if (isVaild(users.getUsername(), users.getPassword())) {
            return DataResult.errorMsg("密码或者用户名不能为空");
        }
        return userService.login(users);
    }

    @RequestMapping("/register")
    public DataResult register(Users users) {
        if (isVaild(users.getUsername(), users.getPassword())) {
            return DataResult.errorMsg("密码或者用户名不能为空");
        }
        DataResult result = userService.queryUsername(users.getUsername());
        if (result.getStatus() != 200) {
            return result;
        }
        return userService.registor(users.getUsername(), users.getPassword());
    }

    @PostMapping("/uploadFace")
    public DataResult uploadImage(@RequestBody UserBo userBo) {
        return userService.upLoadImage(userBo);
    }

    @PostMapping("setNickname")
    public DataResult setNickname(@RequestBody UserBo userBo) {
        return userService.setNickName(userBo);
    }

    @PostMapping("search")
    public DataResult searchFriend(@RequestBody AddFriendRequst requst) {
        return userService.searchFriend(requst);
    }


    public static boolean isVaild(String username, String password) {
        if (username.equals("") || password.equals("")) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {

    }
}   
