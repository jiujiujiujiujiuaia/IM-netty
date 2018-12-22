package com.ycw.wechat.mapper;

import com.ycw.wechat.pojo.bo.AddFriendRequst;
import com.ycw.wechat.pojo.bo.UserBo;
import com.ycw.wechat.pojo.vo.UserVoResult;
import com.ycw.wechat.utils.MyMapper;
import com.ycw.wechat.pojo.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersMapper extends MyMapper<Users> {
    Users queryUsername(String username);

    void registor(String username,String password);

    UserVoResult login(Users users);

    void updateImage(UserBo userBo);

    UserVoResult getUser(UserBo userBo);

    void updateNickName(UserBo userBo);

    UserVoResult selecUserByUserName(String userName);




}