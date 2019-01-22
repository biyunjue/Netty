package com.yunfy.demo.netty.protocol.response;

import com.yunfy.demo.netty.protocol.Packet;
import lombok.Data;

import java.util.List;

import static com.yunfy.demo.netty.protocol.command.Command.CREATE_GROUP_RESPONSE;


/**
 * @author yunfy
 */
@Data
public class CreateGroupResponsePacket extends Packet {
    private boolean success;

    private String groupId;

    private List<String> userNameList;

    @Override
    public Byte getCommand() {
        return CREATE_GROUP_RESPONSE;
    }
}
