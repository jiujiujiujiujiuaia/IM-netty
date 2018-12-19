package com.ycw.wechat.service.impl;

import com.ycw.wechat.mapper.UsersMapper;
import com.ycw.wechat.pojo.Users;
import com.ycw.wechat.pojo.vo.UserBoResult;
import com.ycw.wechat.service.UserService;
import com.ycw.wechat.pojo.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yuchunwei
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public DataResult queryUsername(String username) {
        Users users = usersMapper.queryUsername(username);
        if(users != null){
            return DataResult.errorMsg("用户名已经存在");
        }
       return DataResult.ok("ok");
    }

    @Override
    public DataResult login(Users users) {
       UserBoResult userResult = usersMapper.login(users);
       if(userResult == null){
           return DataResult.errorMsg("用户名或密码错误");
       }
       return DataResult.ok(userResult);
    }

    @Override
    public DataResult registor(String username, String password) {
       usersMapper.registor(username,password);
       return DataResult.ok("注册成功");
    }

    public static void main(String[] args) {

    }
}   
