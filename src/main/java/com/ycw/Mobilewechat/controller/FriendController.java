package com.ycw.Mobilewechat.controller;

import com.ycw.Mobilewechat.pojo.DataResult;
import com.ycw.Mobilewechat.pojo.bo.AddFriendRequst;
import com.ycw.Mobilewechat.pojo.bo.HandleFriendRequest;
import com.ycw.Mobilewechat.pojo.bo.UserBo;
import com.ycw.Mobilewechat.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author yuchunwei
 */
@RestController
@RequestMapping("/f")
public class FriendController {
    @Autowired
    private FriendService friendService;
    @PostMapping("/addFriendRequest")
    public DataResult addFriend(@RequestBody AddFriendRequst requst){
        return friendService.addFriend(requst);
    }
    @RequestMapping("/queryFriendRequests")
    public DataResult queryRequest(UserBo userBo){
        return friendService.queryFriendRequest(userBo.getUserId());
    }
    //忽略是0 同意是1
    @RequestMapping("/operFriendRequest")
    public DataResult operFriendRequest(HandleFriendRequest request){
        return friendService.operFriendRequest(request);
    }
    @RequestMapping("/myFriends")
    public DataResult getAllFriends(String userId){
        return friendService.getAllFriend(userId);
    }

}   
