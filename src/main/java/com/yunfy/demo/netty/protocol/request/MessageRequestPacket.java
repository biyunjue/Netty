package com.yunfy.demo.netty.protocol.request;

import com.yunfy.demo.netty.protocol.Packet;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.yunfy.demo.netty.protocol.command.Command.MESSAGE_REQUEST;

/**
 * @author yunfy
 * @create 2019-01-13 14:15
 **/
@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet {

    private String message;

    public MessageRequestPacket(String message) {
        this.message = message;
    }

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
