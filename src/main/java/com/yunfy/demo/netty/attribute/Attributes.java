package com.yunfy.demo.netty.attribute;

import com.yunfy.demo.netty.session.Session;
import io.netty.util.AttributeKey;

/**
 * @author yunfy
 * @create 2019-01-14 14:26
 **/
public interface Attributes {
    /**
     * 登录的session
     */
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
