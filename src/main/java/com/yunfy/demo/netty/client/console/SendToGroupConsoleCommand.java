package com.yunfy.demo.netty.client.console;

import com.yunfy.demo.netty.protocol.request.GroupMessageRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author yunfy
 * @create 2019-02-02 13:43
 **/
public class SendToGroupConsoleCommand implements ConsoleCommand {
    /**
     * 需要执行的动作
     *
     * @param scanner
     * @param channel
     */
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个某个群组：");

        String toGroupId = scanner.next();
        String message = scanner.next();
        channel.writeAndFlush(new GroupMessageRequestPacket(toGroupId, message));
    }
}
