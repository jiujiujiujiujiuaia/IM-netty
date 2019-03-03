package com.ycw.im.imdistributedroute.service;

import com.ycw.im.imdistributedcom.vo.resp.BaseResponse;
import com.ycw.im.imdistributedroute.vo.req.LoginReq;
import com.ycw.im.imdistributedroute.vo.req.OffLoginReq;
import com.ycw.im.imdistributedroute.vo.req.P2pChatMsg;
import com.ycw.im.imdistributedroute.vo.req.RegisterReq;
import com.ycw.im.imdistributedroute.vo.resp.ServerInfoResp;

public interface AccountSerice {
    //登陆成功即返回服务器信息
    BaseResponse<ServerInfoResp> login(LoginReq loginReq);

    //注册用户,由接口调用方(client)提供Id和userName，这里只作去重校验
    BaseResponse<RegisterReq> registor(RegisterReq registerReq);

    BaseResponse p2pChat(P2pChatMsg msg) throws Exception;

    BaseResponse offLogin(OffLoginReq req);
}
