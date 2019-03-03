package com.ycw.im.imdistributedserver.config;

import com.ycw.im.imdistributedcom.constant.Constants;
import com.ycw.im.imdistributedcom.protocol.RequestProtocol;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yuchunwei
 */
@Configuration
public class BeanConfig {

    @Autowired
    private AppConfiguration appConfiguration;

    @Bean
    public RequestProtocol.ReqProtocol heartbeat() {
        RequestProtocol.ReqProtocol heart = RequestProtocol.ReqProtocol.newBuilder()
                .setRequestId(0L)
                .setReqMsg("服务端pong")
                .setType(Constants.CommandType.PING)
                .build();
        return heart;
    }

    @Bean
    public ZkClient zkClient() {
        return new ZkClient(appConfiguration.getZkAddr(), appConfiguration.getZkConnectTimeout());
    }
}   
