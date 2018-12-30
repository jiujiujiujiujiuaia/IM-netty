package com.ycw.wechat.mapper;

import com.ycw.wechat.pojo.vo.QueryAddFriendRequestVo;
import com.ycw.wechat.pojo.vo.QueryAllFriendVo;
import com.ycw.wechat.utils.MyMapper;
import com.ycw.wechat.pojo.MyFriends;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyFriendsMapper extends MyMapper<MyFriends> {
    List<String> selectFriendIds(@Param("userId") String userId);

    void insertFriend(@Param("acceptUserId") String acceptUserId,@Param("sendUserId") String sendUserId);

    List<QueryAllFriendVo> selectFriends(List<String> ids);
}