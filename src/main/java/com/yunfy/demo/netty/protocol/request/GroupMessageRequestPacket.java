package com.yunfy.demo.netty.protocol.request;

import com.yunfy.demo.netty.protocol.Packet;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.yunfy.demo.netty.protocol.command.Command.GROUP_MESSAGE_REQUEST;

/**
 * @author yunfyl
 * @create 2019-02-02 13:44
 **/
@Data
@NoArgsConstructor
public class GroupMessageRequestPacket extends Packet {

    /**
     * 目标群
     */
    private String toGroupId;

    /**
     * 发送的信息
     */
    private String message;

    public GroupMessageRequestPacket(String toGroupId, String message) {
        this.toGroupId = toGroupId;
        this.message = message;
    }

    /**
     * 指令
     *
     * @return
     */
    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_REQUEST;
    }
}
