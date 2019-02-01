package com.yunfy.demo.netty.protocol.request;

import com.yunfy.demo.netty.protocol.Packet;
import lombok.Data;

import static com.yunfy.demo.netty.protocol.command.Command.LIST_GROUP_MEMBERS_REQUEST;

/**
 * @author yunfy
 * @create 2019-02-01 15:48
 **/
@Data
public class ListGroupMembersRequestPacket extends Packet {

    private String groupId;

    /**
     * 指令
     *
     * @return
     */
    @Override
    public Byte getCommand() {
        return LIST_GROUP_MEMBERS_REQUEST;
    }
}
