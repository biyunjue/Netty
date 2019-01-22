package com.yunfy.demo.netty.util;

import java.util.UUID;

/**
 * @author yunfy
 */
public class IDUtil {
    public static String randomId() {
        return UUID.randomUUID().toString().split("-")[0];
    }
}
