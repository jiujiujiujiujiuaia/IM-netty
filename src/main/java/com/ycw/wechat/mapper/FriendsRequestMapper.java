package com.ycw.wechat.mapper;

import com.ycw.wechat.pojo.bo.AddFriendRequst;
import com.ycw.wechat.pojo.bo.HandleFriendRequest;
import com.ycw.wechat.pojo.vo.QueryAddFriendRequestVo;
import com.ycw.wechat.utils.MyMapper;
import com.ycw.wechat.pojo.FriendsRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendsRequestMapper extends MyMapper<FriendsRequest> {

    void insertAddFriendRequst(AddFriendRequst requst);

    List<QueryAddFriendRequestVo> queryFriendRequst(@Param("userId") String userId);

    void updateStatus(HandleFriendRequest request);
 }