package com.ycw.wechat.service.impl;

import com.ycw.wechat.mapper.UsersMapper;
import com.ycw.wechat.pojo.Users;
import com.ycw.wechat.service.UserService;
import com.ycw.wechat.utils.DataResult;
import org.omg.CORBA.DATA_CONVERSION;
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
    public DataResult login(String username, String password) {
       Users users = usersMapper.login(username,password);
       if(users == null){
           return DataResult.errorMsg("用户名或密码错误");
       }
       return DataResult.ok("登陆成功");
    }

    @Override
    public DataResult registor(String username, String password) {
       usersMapper.registor(username,password);
       return DataResult.ok("注册成功");
    }

    public static void main(String[] args) {

    }
}   
