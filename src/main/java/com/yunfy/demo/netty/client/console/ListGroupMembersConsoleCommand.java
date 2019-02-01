package com.yunfy.demo.netty.client.console;

import com.yunfy.demo.netty.protocol.request.ListGroupMembersRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author yunfy
 * @create 2019-02-01 15:47
 **/
public class ListGroupMembersConsoleCommand implements ConsoleCommand {

    /**
     * 需要执行的动作
     *
     * @param scanner
     * @param channel
     */
    @Override
    public void exec(Scanner scanner, Channel channel) {
        ListGroupMembersRequestPacket listGroupMembersRequestPacket = new ListGroupMembersRequestPacket();

        System.out.print("输入 groupId，获取群成员列表：");
        String groupId = scanner.next();

        listGroupMembersRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(listGroupMembersRequestPacket);
    }
}
