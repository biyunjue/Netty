package com.yunfy.demo.netty.protocol.response;

import com.yunfy.demo.netty.protocol.Packet;
import lombok.Data;

import static com.yunfy.demo.netty.protocol.command.Command.LOGOUT_RESPONSE;


/**
 * @author yunfy
 */
@Data
public class LogoutResponsePacket extends Packet {

    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {
        return LOGOUT_RESPONSE;
    }
}
