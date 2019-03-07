package com.ycw.im.imdistributedserver.controller;

import com.ycw.im.imdistributedcom.vo.resp.BaseResponse;
import com.ycw.im.imdistributedserver.server.Server;
import com.ycw.im.imdistributedserver.vo.request.SendMsgReqVo;
import io.swagger.annotations.ApiOperation;
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
public class ChatController {
    @Autowired
    private Server server;

    @ApiOperation("服务端发送消息")
    @RequestMapping(value = "sendMsg",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse sendMsg(@RequestBody SendMsgReqVo sendMsgReqVO){
        return server.sendMsg(sendMsgReqVO);
    }
}   
