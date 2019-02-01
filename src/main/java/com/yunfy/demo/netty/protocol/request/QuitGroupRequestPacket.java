package com.yunfy.demo.netty.protocol.request;

import com.yunfy.demo.netty.protocol.Packet;
import lombok.Data;

import static com.yunfy.demo.netty.protocol.command.Command.QUIT_GROUP_REQUEST;

/**
 * @author yunfy
 * @create 2019-02-01 15:39
 **/
@Data
public class QuitGroupRequestPacket extends Packet {

    private String groupId;

    /**
     * 指令
     *
     * @return
     */
    @Override
    public Byte getCommand() {
        return QUIT_GROUP_REQUEST;
    }
}
