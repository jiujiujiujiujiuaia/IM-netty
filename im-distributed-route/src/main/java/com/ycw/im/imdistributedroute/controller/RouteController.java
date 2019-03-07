package com.ycw.im.imdistributedroute.controller;

import com.ycw.im.imdistributedcom.vo.resp.BaseResponse;
import com.ycw.im.imdistributedroute.service.AccountSerice;
import com.ycw.im.imdistributedroute.vo.req.LoginReq;
import com.ycw.im.imdistributedroute.vo.req.OffLoginReq;
import com.ycw.im.imdistributedroute.vo.req.P2pChatMsg;
import com.ycw.im.imdistributedroute.vo.req.RegisterReq;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author yuchunwei
 */
@Controller
@RequestMapping("/")
public class RouteController {
    private final static Logger LOGGER = LoggerFactory.getLogger(RouteController.class);

    @Autowired
    private AccountSerice accountSerice;

    @ApiOperation("私聊 API")
    @RequestMapping(value = "p2pchat", method = RequestMethod.POST)
    @ResponseBody()
    public BaseResponse p2pchat(@RequestBody  P2pChatMsg msg) throws Exception{
        return accountSerice.p2pChat(msg);
    }

    @ApiOperation("注册 API")
    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody()
    public BaseResponse registor(@RequestBody RegisterReq registerReq){
        return accountSerice.registor(registerReq);
    }

    @ApiOperation("登陆 API")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody()
    public BaseResponse login(@RequestBody LoginReq loginReq){
        return accountSerice.login(loginReq);
    }


    @ApiOperation("下线 API")
    @RequestMapping(value = "off", method = RequestMethod.POST)
    @ResponseBody()
    public BaseResponse offLogin(@RequestBody OffLoginReq offLoginReq){
        return accountSerice.offLogin(offLoginReq);
    }







}   
