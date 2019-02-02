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

    /**
     * 获取群组列表请求
     */
    Byte LIST_GROUP_MEMBERS_REQUEST = 9;

    /**
     * 获取群组列表响应
     */
    Byte LIST_GROUP_MEMBERS_RESPONSE = 10;

    /**
     * 加入群组列表请求
     */
    Byte JOIN_GROUP_REQUEST = 11;

    /**
     * 加入群组列表响应
     */
    Byte JOIN_GROUP_RESPONSE = 12;

    /**
     * 离开群组列表请求
     */
    Byte QUIT_GROUP_REQUEST = 13;

    /**
     * 离开群组列表响应
     */
    Byte QUIT_GROUP_RESPONSE = 14;

    /**
     * 发送群消息请求
     */
    Byte GROUP_MESSAGE_REQUEST = 15;

    /**
     * 发送群消息响应
     */
    Byte GROUP_MESSAGE_RESPONSE = 16;
}
