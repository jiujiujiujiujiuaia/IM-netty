package com.ycw.im.imdistributedroute.vo.resp;

import lombok.Data;

import java.io.Serializable;


/**
 * @Author yuchunwei
 */
@Data
public class ServerInfoResp implements Serializable {
    private String ip;
    private int httpPort;
    private int nettyPort;
    public ServerInfoResp(String ip,int httpPort,int nettyPort){
        this.ip = ip;
        this.httpPort = httpPort;
        this.nettyPort = nettyPort;
    }
}   
