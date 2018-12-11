package com.ycw.wechat.mapper;

import com.ycw.wechat.utils.MyMapper;
import com.ycw.wechat.pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper extends MyMapper<Users> {
    Users queryUsername(String username);
    void registor(String username,String password);
    Users login(@Param("username") String username, @Param("password") String password);
}