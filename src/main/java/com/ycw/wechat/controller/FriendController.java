package com.ycw.wechat.controller;

import com.ycw.wechat.pojo.DataResult;
import com.ycw.wechat.pojo.bo.AddFriendRequst;
import com.ycw.wechat.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yuchunwei
 */
@RestController
@RequestMapping("/f")
public class FriendController {
    @Autowired
    private FriendService friendService;
    @PostMapping("addFriendRequest")
    public DataResult addFriend(@RequestBody AddFriendRequst requst){
        return friendService.addFriend(requst);
    }

}   
