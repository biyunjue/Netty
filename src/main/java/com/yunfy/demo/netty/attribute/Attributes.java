package com.yunfy.demo.netty.attribute;

import io.netty.util.AttributeKey;

/**
 * @author yunfy
 * @create 2019-01-14 14:26
 **/
public interface Attributes {
    /**
     * 定义状态
     */
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
}
