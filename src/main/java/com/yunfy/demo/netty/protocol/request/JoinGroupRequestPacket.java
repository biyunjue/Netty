package com.yunfy.demo.netty.protocol.request;

import com.yunfy.demo.netty.protocol.Packet;
import lombok.Data;

import static com.yunfy.demo.netty.protocol.command.Command.JOIN_GROUP_REQUEST;

/**
 * @author yunfy
 * @create 2019-02-01 15:17
 **/
@Data
public class JoinGroupRequestPacket extends Packet {

    private String groupId;

    /**
     * 指令
     *
     * @return
     */
    @Override
    public Byte getCommand() {
        return JOIN_GROUP_REQUEST;
    }
}
