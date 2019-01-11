package com.hejian.demo.netty.protocol.command;

import lombok.Data;

import static com.hejian.demo.netty.protocol.command.Command.LOGIN_REQUEST;

/**
 * @author hj
 * @create 2019-01-11 11:32
 **/
@Data
public class LoginRequestPacket extends Packet {
    private Integer userId;

    private String username;

    private String password;

    /**
     * 指令
     *
     * @return
     */
    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
