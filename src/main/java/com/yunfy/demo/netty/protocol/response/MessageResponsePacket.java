package com.yunfy.demo.netty.protocol.response;

import com.yunfy.demo.netty.protocol.Packet;
import lombok.Data;

import static com.yunfy.demo.netty.protocol.command.Command.MESSAGE_RESPONSE;

/**
 * @author yunfy
 * @create 2019-01-14 14:18
 **/
@Data
public class MessageResponsePacket extends Packet {

    private String message;

    /**
     * 指令
     *
     * @return
     */
    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}
