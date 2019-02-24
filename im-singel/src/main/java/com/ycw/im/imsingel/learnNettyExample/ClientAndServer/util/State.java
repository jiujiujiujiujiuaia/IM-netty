package com.ycw.im.imsingel.learnNettyExample.ClientAndServer.util;

import io.netty.util.AttributeKey;
//接口中声明变量默认的是static final
public interface State {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
    AttributeKey<String> USERNAME = AttributeKey.newInstance("username");
}
