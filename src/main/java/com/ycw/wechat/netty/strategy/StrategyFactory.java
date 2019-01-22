package com.ycw.wechat.netty.strategy;

import com.ycw.wechat.enums.MsgStateEnum;
import com.ycw.wechat.netty.strategy.impl.*;

import java.util.HashMap;

/**
 * @Author yuchunwei
 */
public class StrategyFactory {
    private static StrategyFactory factory = new StrategyFactory();
    private StrategyFactory(){
    }
    private static HashMap<Integer,Strategy> map= new HashMap<>();

    static {
        map.put(MsgStateEnum.CONNECT.getCode(),new ConnectStrategy());
        map.put(MsgStateEnum.CHAT.getCode(),new ChatStrategy());
        map.put(MsgStateEnum.CLOSE.getCode(),new CloseStrategy());
        map.put(MsgStateEnum.KEEPALIVE.getCode(),new HeartCheckStrategy());
        map.put(MsgStateEnum.SIGNED.getCode(),new SignStrategy());
    }

    public Strategy create(Integer type){
        return map.get(type);
    }
    public static StrategyFactory getInstance(){
        return factory;
    }
}   
