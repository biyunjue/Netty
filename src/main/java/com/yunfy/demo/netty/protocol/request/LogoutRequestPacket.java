package com.yunfy.demo.netty.protocol.request;

import com.yunfy.demo.netty.protocol.Packet;
import lombok.Data;

import static com.yunfy.demo.netty.protocol.command.Command.LOGOUT_REQUEST;


/**
 * @author yunfy
 */
@Data
public class LogoutRequestPacket extends Packet {
    @Override
    public Byte getCommand() {

        return LOGOUT_REQUEST;
    }
}
