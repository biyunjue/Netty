package com.yunfy.demo.netty.protocol.request;

import com.yunfy.demo.netty.protocol.Packet;

import static com.yunfy.demo.netty.protocol.command.Command.HEARTBEAT_REQUEST;

/**
 * @author yunfy
 * @create 2019-02-03 18:01
 **/
public class HeartBeatRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_REQUEST;
    }
}
