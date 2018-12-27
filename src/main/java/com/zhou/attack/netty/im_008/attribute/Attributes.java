package com.zhou.attack.netty.im_008.attribute;

import com.zhou.attack.netty.im_011.Session;
import io.netty.util.AttributeKey;

/**
 * Created by zhoumb on 2018/12/27
 */
public class Attributes {
    public static AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
    public static AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
