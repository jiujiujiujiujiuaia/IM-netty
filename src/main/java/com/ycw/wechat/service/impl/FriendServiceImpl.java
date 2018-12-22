package com.ycw.wechat.service.impl;

import com.ycw.wechat.enums.AddFriendRequstEnum;
import com.ycw.wechat.mapper.FriendsRequestMapper;
import com.ycw.wechat.mapper.MyFriendsMapper;
import com.ycw.wechat.pojo.DataResult;
import com.ycw.wechat.pojo.bo.AddFriendRequst;
import com.ycw.wechat.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
}   
