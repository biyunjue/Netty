package com.yunfy.demo.netty.protocol.request;

import com.yunfy.demo.netty.protocol.Packet;
import lombok.Data;

import java.util.List;

import static com.yunfy.demo.netty.protocol.command.Command.CREATE_GROUP_REQUEST;

/**
 * @author yunfy
 * @create 2019-01-22 21:21
 **/
@Data
public class CreateGroupRequestPacket extends Packet {

    private List<String> userIdList;

    @Override
    public Byte getCommand() {

        return CREATE_GROUP_REQUEST;
    }
}
