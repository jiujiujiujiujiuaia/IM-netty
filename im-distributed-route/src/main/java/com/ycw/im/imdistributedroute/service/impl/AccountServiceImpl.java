package com.ycw.im.imdistributedroute.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ycw.im.imdistributedcom.pojo.UserInfo;
import com.ycw.im.imdistributedcom.vo.resp.BaseResponse;
import com.ycw.im.imdistributedroute.service.AccountSerice;
import com.ycw.im.imdistributedroute.service.UserLocalCacheService;
import com.ycw.im.imdistributedroute.tool.ServerRouteCache;
import com.ycw.im.imdistributedroute.vo.req.LoginReq;
import com.ycw.im.imdistributedroute.vo.req.OffLoginReq;
import com.ycw.im.imdistributedroute.vo.req.P2pChatMsg;
import com.ycw.im.imdistributedroute.vo.req.RegisterReq;
import com.ycw.im.imdistributedroute.vo.resp.RegistorResp;
import com.ycw.im.imdistributedroute.vo.resp.ServerInfoResp;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import static com.ycw.im.imdistributedcom.enums.StatusEnum.*;

/**
 * @Author yuchunwei
 */
@Service
public class AccountServiceImpl implements AccountSerice {

    private final static Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);


    //redis存储已经注册用户，已经登陆用户请求得路由
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private UserLocalCacheService LocalLoginUserCache;

    @Autowired
    private ServerRouteCache LocalrouteCache;

    @Autowired
    private OkHttpClient client ;

    //已经注册用户key
    private final String ACCOUNT_PREFIX = "im-account:";
    //已经登陆用户的路由地址
    private final String ROUTE_PREFIX = "im-route:";
    private MediaType mediaType = MediaType.parse("application/json");



    //鉴定id是否注册过，用户名是否重名
    @Override
    public BaseResponse<RegisterReq> registor(RegisterReq registerReq) {
        RegistorResp registorResp = new RegistorResp();
        String key = ACCOUNT_PREFIX + registerReq.getUserId();
        String userName = registerReq.getUserName();
        boolean isRegistor = redisTemplate.opsForValue().get(key) == null ;
        boolean isUserNameRepeat = redisTemplate.opsForValue().get(userName) == null ;


        if(isRegistor && isUserNameRepeat){
            //方便查询，冗余两份
            redisTemplate.opsForValue().set(key,userName);
            redisTemplate.opsForValue().set(userName,key);
        }
        else if(!isRegistor) {
            registerReq.setUserId(registerReq.getUserId());
            return BaseResponse.error(registerReq,REPEAT_USERID.getDescription(),REPEAT_USERID.getCode());
        }
        else if(!isUserNameRepeat){
            registorResp.setUserName(userName);
            return BaseResponse.error(registerReq, REPEAT_USERNAME.getDescription(),REPEAT_USERNAME.getCode());
        }

        return BaseResponse.ok(registerReq, REGISTOR_SUCCESS.getDescription(),REGISTOR_SUCCESS.getCode());

    }

    //私聊
    @Override
    public BaseResponse p2pChat(P2pChatMsg msg) throws Exception {
        BaseResponse res = new BaseResponse();
        ServerInfoResp ip = getIpByUserId(msg.getReceiveUserId());
        if(ip == null ){
            res.setStatus(OFF_LINE.getCode());
            res.setMessage(OFF_LINE.getDescription());
            return res;
        }

        String url = "http://" + ip.getIp() + ":" + ip.getHttpPort() + "/sendMsg" ;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", msg.getUserName() + ":【" + msg.getMsg() + "】");
        jsonObject.put("userId", msg.getReceiveUserId());
        RequestBody requestBody = RequestBody.create(mediaType,jsonObject.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        try {
            if (!response.isSuccessful()) {
                res.setStatus(SEND_FAIL.getCode());
                res.setMessage(SEND_FAIL.getDescription());
            }
        }finally {
            response.body().close();
        }
        res = new BaseResponse(null,SEND_SUCCESS.getDescription(),SEND_SUCCESS.getCode());
        return res;
    }

    //登陆
    @Override
    public BaseResponse<ServerInfoResp> login(LoginReq loginReq) {
        Long userId = loginReq.getUserId();
        String key = ACCOUNT_PREFIX + userId;
        String userName = redisTemplate.opsForValue().get(key);
        //该用户是否注册过
        if(userName != null && userName.equals(loginReq.getUserName())){
            //该用户是否已经登陆
            if(LocalLoginUserCache.isAlreadLogin(loginReq.getUserId())){
                return BaseResponse.error(null,REPEAT_LOGIN.getDescription(),REPEAT_LOGIN.getCode());
            }
        }
        else {
            return BaseResponse.error(null,NOTREGISTOR.getDescription(),NOTREGISTOR.getCode());
        }

        //登陆验证通过，挑选服务器路由并返回

        //将登陆成功用户加入在线用户表
        UserInfo userInfo = new UserInfo(loginReq.getUserId(),loginReq.getUserName());
        LocalLoginUserCache.cacheLogin(userInfo);

        //挑选服务器路由，将用户和服务器路由绑定在一起
        String ip = LocalrouteCache.select();
        redisTemplate.opsForValue().append(ROUTE_PREFIX+userId,ip);
        String[] ipAndPort = ip.split(":") ;
        ServerInfoResp serverInfoResp = new ServerInfoResp(ipAndPort[0],Integer.parseInt(ipAndPort[1]),
                Integer.parseInt(ipAndPort[2]));
        return BaseResponse.ok(serverInfoResp,LOGIN_SUCCESS.getDescription(),LOGIN_SUCCESS.getCode());
    }

    @Override
    public BaseResponse offLogin(OffLoginReq req) {
        UserInfo userInfo = LocalLoginUserCache.getUserInfoById(req.getUserId());
        LOGGER.info("下线用户[{}]" ,userInfo.toString());

        LocalLoginUserCache.cacheOffLogin(req);
        redisTemplate.delete(ROUTE_PREFIX+req.getUserId());

        return BaseResponse.ok(null,"下线成功");
    }

    private ServerInfoResp getIpByUserId(Long userid){
        ServerInfoResp resp  = null;
        String ip = redisTemplate.opsForValue().get(ROUTE_PREFIX+userid);
        if(ip != null && !ip.equals("")){
            String[] ipAndPort = ip.split(":");
            resp = new ServerInfoResp(ipAndPort[0],Integer.valueOf(ipAndPort[1]),
                    Integer.valueOf(ipAndPort[2]));
        }
        return resp ;
    }


}
