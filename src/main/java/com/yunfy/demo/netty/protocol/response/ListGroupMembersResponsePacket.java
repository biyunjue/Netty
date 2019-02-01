package com.yunfy.demo.netty.protocol.response;

import com.yunfy.demo.netty.protocol.Packet;
import com.yunfy.demo.netty.session.Session;
import lombok.Data;

import java.util.List;

import static com.yunfy.demo.netty.protocol.command.Command.LIST_GROUP_MEMBERS_RESPONSE;

/**
 * @author yunfy
 * @create 2019-02-01 15:51
 **/
@Data
public class ListGroupMembersResponsePacket extends Packet {

    private String groupId;

    private List<Session> sessionList;

    /**
     * 指令
     *
     * @return
     */
    @Override
    public Byte getCommand() {
        return LIST_GROUP_MEMBERS_RESPONSE;
    }
}
