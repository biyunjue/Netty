package com.yunfy.demo.netty.client.console;

import com.yunfy.demo.netty.protocol.request.JoinGroupRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author yunfy
 * @create 2019-02-01 15:16
 **/
public class JoinGroupConsoleCommand implements ConsoleCommand {
    /**
     * 需要执行的动作
     *
     * @param scanner
     * @param channel
     */
    @Override
    public void exec(Scanner scanner, Channel channel) {
        JoinGroupRequestPacket joinGroupRequestPacket = new JoinGroupRequestPacket();

        System.out.print("输入 groupId，加入群聊：");
        String groupId = scanner.next();
        joinGroupRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(joinGroupRequestPacket);
    }
}
