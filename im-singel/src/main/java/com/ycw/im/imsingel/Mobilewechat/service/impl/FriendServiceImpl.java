package com.ycw.im.imsingel.Mobilewechat.service.impl;

import com.ycw.im.imsingel.Mobilewechat.enums.AddFriendRequstEnum;
import com.ycw.im.imsingel.Mobilewechat.mapper.FriendsRequestMapper;
import com.ycw.im.imsingel.Mobilewechat.mapper.MyFriendsMapper;
import com.ycw.im.imsingel.Mobilewechat.pojo.DataResult;
import com.ycw.im.imsingel.Mobilewechat.pojo.bo.AddFriendRequst;
import com.ycw.im.imsingel.Mobilewechat.pojo.bo.HandleFriendRequest;
import com.ycw.im.imsingel.Mobilewechat.pojo.vo.QueryAddFriendRequestVo;
import com.ycw.im.imsingel.Mobilewechat.pojo.vo.QueryAllFriendVo;
import com.ycw.im.imsingel.Mobilewechat.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author yuchunwei
 */
@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    private MyFriendsMapper myFriendsMapper;
    @Autowired
    private FriendsRequestMapper friendsRequestMapper;

    @Override
    public DataResult addFriend(AddFriendRequst requst){
        if(requst.getMyUserId().equals(requst.getFriendId())){
            return DataResult.errorMsg(AddFriendRequstEnum.ISYOURSELF.getMessage());
        }
        else {
            List<String> friends = myFriendsMapper.selectFriendIds(requst.getMyUserId());
            if(friends.contains(requst.getFriendId())){
                return DataResult.errorMsg(AddFriendRequstEnum.ISYOURFRIEND.getMessage());
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss");
            requst.setDate(sdf.format(new Date()));
            friendsRequestMapper.insertAddFriendRequst(requst);
        }
        return DataResult.ok();
    }

    @Override
    public DataResult queryFriendRequest(String userId){
        if(userId !=null && !userId.equals("")){
           List<QueryAddFriendRequestVo> vo  =  friendsRequestMapper.queryFriendRequst(userId);
           return DataResult.ok(vo);
        }
        return DataResult.errorMsg("请先登陆");
    }
    @Override
    public  DataResult operFriendRequest(HandleFriendRequest request){
        request.setStatus(AddFriendRequstEnum.HANDLED.getCode());
        friendsRequestMapper.updateStatus(request);
        if(request.getOperType().equals("1")){
            myFriendsMapper.insertFriend(request.getAcceptUserId(),request.getSendUserId());
            myFriendsMapper.insertFriend(request.getSendUserId(),request.getAcceptUserId());
        }
        List<String> ids = myFriendsMapper.selectFriendIds(request.getAcceptUserId());
        List<QueryAllFriendVo> res = myFriendsMapper.selectFriends(ids);
        return DataResult.ok(res);
    }
    @Override
    public DataResult getAllFriend(String userId){
        System.out.println("获取所有好友");
        List<QueryAllFriendVo> res = new ArrayList<>();
        List<String> ids = myFriendsMapper.selectFriendIds(userId);
        if(ids.size() > 0) res = myFriendsMapper.selectFriends(ids);
        return DataResult.ok(res);
    }
}   
