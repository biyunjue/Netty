package com.yunfy.demo.netty.protocol.request;

import com.yunfy.demo.netty.protocol.Packet;
import lombok.Data;

import static com.yunfy.demo.netty.protocol.command.Command.MESSAGE_REQUEST;

/**
 * @author yunfy
 * @create 2019-01-13 14:15
 **/
@Data
public class MessageRequestPacket extends Packet {

    private String message;

    /**
     * 指令
     *
     * @return
     */
    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
