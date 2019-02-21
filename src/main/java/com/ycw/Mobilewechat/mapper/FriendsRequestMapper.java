package com.ycw.Mobilewechat.mapper;

import com.ycw.Mobilewechat.pojo.bo.AddFriendRequst;
import com.ycw.Mobilewechat.pojo.bo.HandleFriendRequest;
import com.ycw.Mobilewechat.pojo.vo.QueryAddFriendRequestVo;
import com.ycw.Mobilewechat.utils.MyMapper;
import com.ycw.Mobilewechat.pojo.FriendsRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendsRequestMapper extends MyMapper<FriendsRequest> {

    void insertAddFriendRequst(AddFriendRequst requst);

    List<QueryAddFriendRequestVo> queryFriendRequst(@Param("userId") String userId);

    void updateStatus(HandleFriendRequest request);
 }