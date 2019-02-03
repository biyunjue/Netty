package com.yunfy.demo.netty.protocol.response;

import com.yunfy.demo.netty.protocol.Packet;

import static com.yunfy.demo.netty.protocol.command.Command.HEARTBEAT_RESPONSE;

/**
 * @author yunfy
 * @create 2019-02-03 18:08
 **/
public class HeartBeatResponsePacket extends Packet {
    /**
     * 指令
     *
     * @return
     */
    @Override
    public Byte getCommand() {
        return HEARTBEAT_RESPONSE;
    }
}
