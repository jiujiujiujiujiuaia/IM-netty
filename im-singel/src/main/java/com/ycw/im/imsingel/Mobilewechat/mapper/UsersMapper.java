package com.ycw.im.imsingel.Mobilewechat.mapper;

import com.ycw.im.imsingel.Mobilewechat.pojo.bo.UserBo;
import com.ycw.im.imsingel.Mobilewechat.pojo.vo.UserVoResult;
import com.ycw.im.imsingel.Mobilewechat.pojo.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper  {
    Users queryUsername(String username);

    void registor(String username, String password);

    UserVoResult login(Users users);

    void updateImage(UserBo userBo);

    UserVoResult getUser(UserBo userBo);

    void updateNickName(UserBo userBo);

    UserVoResult selecUserByUserName(String userName);




}