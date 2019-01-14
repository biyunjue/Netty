package com.yunfy.demo.netty.util;

import com.yunfy.demo.netty.attribute.Attributes;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

/**
 * @author yunfy
 * @create 2019-01-14 14:28
 **/
public class LoginUtil {
    /**
     * 标志登录成功
     *
     * @param channel
     */
    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);
        //不管标志位的值是什么，都表示已经成功登录过
        return loginAttr.get() != null;
    }
}
