package com.yunfy.demo.netty.client.console;

import com.yunfy.demo.netty.protocol.request.QuitGroupRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author yunfy
 * @create 2019-02-01 15:38
 **/
public class QuitGroupConsoleCommand implements ConsoleCommand {
    /**
     * 需要执行的动作
     *
     * @param scanner
     * @param channel
     */
    @Override
    public void exec(Scanner scanner, Channel channel) {
        QuitGroupRequestPacket quitGroupRequestPacket = new QuitGroupRequestPacket();

        System.out.print("输入 groupId，退出群聊：");
        String groupId = scanner.next();

        quitGroupRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(quitGroupRequestPacket);
    }
}
