package com.hejian.demo.netty.protocol.response;

import com.hejian.demo.netty.protocol.Packet;
import lombok.Data;

import static com.hejian.demo.netty.protocol.command.Command.LOGIN_RESPONSE;

/**
 * @author hj
 */
@Data
public class LoginResponsePacket extends Packet {
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
