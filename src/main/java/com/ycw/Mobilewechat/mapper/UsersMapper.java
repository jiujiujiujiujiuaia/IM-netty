package com.ycw.Mobilewechat.mapper;

import com.ycw.Mobilewechat.pojo.bo.UserBo;
import com.ycw.Mobilewechat.pojo.vo.UserVoResult;
import com.ycw.Mobilewechat.utils.MyMapper;
import com.ycw.Mobilewechat.pojo.Users;
import org.springframework.stereotype.Repository;

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