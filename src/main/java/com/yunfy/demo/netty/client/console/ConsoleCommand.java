package com.yunfy.demo.netty.client.console;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author yunfy
 * @create 2019-01-22 21:13
 **/
public interface ConsoleCommand {
    /**
     * 需要执行的动作
     *
     * @param scanner
     * @param channel
     */
    void exec(Scanner scanner, Channel channel);
}
