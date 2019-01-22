package com.yunfy.demo.netty.protocol.command;

public interface Command {

    /**
     * 登录请求
     */
    Byte LOGIN_REQUEST = 1;

    /**
     * 登录响应
     */
    Byte LOGIN_RESPONSE = 2;

    /**
     * 消息请求
     */
    Byte MESSAGE_REQUEST = 3;

    /**
     * 消息响应
     */
    Byte MESSAGE_RESPONSE = 4;

    /**
     * 退出请求
     */
    Byte LOGOUT_REQUEST = 5;

    /**
     * 退出响应
     */
    Byte LOGOUT_RESPONSE = 6;

    /**
     * 建立群组请求
     */
    Byte CREATE_GROUP_REQUEST = 7;

    /**
     * 建立群组响应
     */
    Byte CREATE_GROUP_RESPONSE = 8;
}
