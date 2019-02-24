package com.ycw.im.imsingel.Mobilewechat.mapper;

import com.ycw.im.imsingel.Mobilewechat.pojo.vo.QueryAllFriendVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyFriendsMapper {
    List<String> selectFriendIds(@Param("userId") String userId);

    void insertFriend(@Param("acceptUserId") String acceptUserId, @Param("sendUserId") String sendUserId);

    List<QueryAllFriendVo> selectFriends(List<String> ids);
}