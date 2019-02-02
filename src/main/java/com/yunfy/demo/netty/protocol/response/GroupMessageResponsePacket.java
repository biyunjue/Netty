package com.yunfy.demo.netty.protocol.response;

import com.yunfy.demo.netty.protocol.Packet;
import com.yunfy.demo.netty.session.Session;
import lombok.Data;

import static com.yunfy.demo.netty.protocol.command.Command.GROUP_MESSAGE_RESPONSE;

/**
 * @author yunfy
 * @create 2019-02-02 13:49
 **/
@Data
public class GroupMessageResponsePacket extends Packet {

    private String fromGroupId;

    private Session fromUser;

    private String message;

    /**
     * 指令
     *
     * @return
     */
    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_RESPONSE;
    }
}
