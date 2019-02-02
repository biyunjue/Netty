package com.yunfy.demo.netty.server.handler;

import com.yunfy.demo.netty.protocol.request.JoinGroupRequestPacket;
import com.yunfy.demo.netty.protocol.response.JoinGroupResponsePacket;
import com.yunfy.demo.netty.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @author yunfy
 * @create 2019-02-01 15:26
 **/
@ChannelHandler.Sharable
public class JoinGroupRequestHandler extends SimpleChannelInboundHandler<JoinGroupRequestPacket> {

    public static final JoinGroupRequestHandler INSTANCE = new JoinGroupRequestHandler();

    private JoinGroupRequestHandler() {

    }

    /**
     * <strong>Please keep in mind that this method will be renamed to
     * {@code messageReceived(ChannelHandlerContext, I)} in 5.0.</strong>
     * <p>
     * Is called for each message of type {@link JoinGroupRequestPacket}.
     *
     * @param ctx the {@link ChannelHandlerContext} which this {@link SimpleChannelInboundHandler}
     *            belongs to
     * @param requestPacket the message to handle
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupRequestPacket requestPacket) {
        // 1. 获取群对应的 channelGroup，然后将当前用户的 channel 添加进去
        String groupId = requestPacket.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);

        // 2. 构造加群响应发送给客户端
        JoinGroupResponsePacket responsePacket = new JoinGroupResponsePacket();

        if (channelGroup == null) {
            responsePacket.setSuccess(false);
            responsePacket.setReason(groupId + "群不存在");
        } else {
            channelGroup.add(ctx.channel());
            responsePacket.setSuccess(true);
            responsePacket.setGroupId(groupId);
        }
        ctx.writeAndFlush(responsePacket);
    }
}
