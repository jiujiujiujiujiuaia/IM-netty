package com.ycw.wechat.controller;

import com.ycw.wechat.pojo.Users;
import com.ycw.wechat.pojo.bo.UserBo;
import com.ycw.wechat.service.UserService;
import com.ycw.wechat.pojo.DataResult;
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
    public DataResult login(@RequestBody Users users){
       if(isVaild(users.getUsername(),users.getPassword())){
           return DataResult.errorMsg("密码或者用户名不能为空");
       }
       return userService.login(users);
    }
    @RequestMapping("/register")
    public DataResult register(Users users){
        if(isVaild(users.getUsername(),users.getPassword())){
            return DataResult.errorMsg("密码或者用户名不能为空");
        }
        DataResult result = userService.queryUsername(users.getUsername());
        if(result.getStatus() != 200){
            return result;
        }
        return userService.registor(users.getUsername(),users.getPassword());
    }
    @PostMapping("/uploadFace")
    public DataResult uploadImage(@RequestBody UserBo userBo){
        return userService.upLoadImage(userBo);
    }



    private boolean isVaild(String username,String password){
        if(username.equals("") || password.equals("")){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {

    }
}   
