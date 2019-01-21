package com.yunfy.demo.netty.protocol.response;

import com.yunfy.demo.netty.protocol.Packet;
import lombok.Data;

import static com.yunfy.demo.netty.protocol.command.Command.LOGIN_RESPONSE;

/**
 * @author yunfy
 */
@Data
public class LoginResponsePacket extends Packet {

    private String userId;

    private String userName;

    private boolean success;

    private String reason;


    /**
     * 指令
     *
     * @return
     */
    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
