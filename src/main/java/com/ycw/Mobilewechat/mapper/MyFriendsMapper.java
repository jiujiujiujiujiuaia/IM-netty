package com.ycw.Mobilewechat.mapper;

import com.ycw.Mobilewechat.pojo.vo.QueryAllFriendVo;
import com.ycw.Mobilewechat.utils.MyMapper;
import com.ycw.Mobilewechat.pojo.MyFriends;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyFriendsMapper extends MyMapper<MyFriends> {
    List<String> selectFriendIds(@Param("userId") String userId);

    void insertFriend(@Param("acceptUserId") String acceptUserId,@Param("sendUserId") String sendUserId);

    List<QueryAllFriendVo> selectFriends(List<String> ids);
}