package com.ycw.im.imsingel.Mobilewechat.mapper;

import com.ycw.im.imsingel.Mobilewechat.pojo.bo.AddFriendRequst;
import com.ycw.im.imsingel.Mobilewechat.pojo.bo.HandleFriendRequest;
import com.ycw.im.imsingel.Mobilewechat.pojo.vo.QueryAddFriendRequestVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendsRequestMapper {

    void insertAddFriendRequst(AddFriendRequst requst);

    List<QueryAddFriendRequestVo> queryFriendRequst(@Param("userId") String userId);

    void updateStatus(HandleFriendRequest request);
 }