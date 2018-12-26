package com.zhou.attack.netty.im_007;

import io.netty.util.AttributeKey;

/**
 * Created by zhoumb on 2018/12/26
 */
public interface Attributes {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
}
