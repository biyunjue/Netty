package com.yunfy.demo.netty.protocol.response;

import com.yunfy.demo.netty.protocol.Packet;
import lombok.Data;

import static com.yunfy.demo.netty.protocol.command.Command.QUIT_GROUP_RESPONSE;

/**
 * @author yunfy
 * @create 2019-02-01 15:42
 **/
@Data
public class QuitGroupResponsePacket extends Packet {

    /**
     * 群组ID
     */
    private String groupId;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 失败原因
     */
    private String reason;

    /**
     * 指令
     *
     * @return
     */
    @Override
    public Byte getCommand() {
        return QUIT_GROUP_RESPONSE;
    }
}
