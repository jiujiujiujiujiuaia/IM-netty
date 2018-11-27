package com.ycw.im.Learn.util;

import io.netty.util.AttributeKey;

public interface State {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
    AttributeKey<String> ID = AttributeKey.newInstance("id");
}
