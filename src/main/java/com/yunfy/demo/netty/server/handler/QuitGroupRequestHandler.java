package com.yunfy.demo.netty.server.handler;

import com.yunfy.demo.netty.protocol.request.QuitGroupRequestPacket;
import com.yunfy.demo.netty.protocol.response.QuitGroupResponsePacket;
import com.yunfy.demo.netty.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @author yunfy
 * @create 2019-02-01 15:40
 **/
@ChannelHandler.Sharable
public class QuitGroupRequestHandler extends SimpleChannelInboundHandler<QuitGroupRequestPacket> {
    public static final QuitGroupRequestHandler INSTANCE = new QuitGroupRequestHandler();

    private QuitGroupRequestHandler() {

    }

    /**
     * <strong>Please keep in mind that this method will be renamed to
     * {@code messageReceived(ChannelHandlerContext, I)} in 5.0.</strong>
     * <p>
     * Is called for each message of type {@link QuitGroupRequestPacket}.
     *
     * @param ctx the {@link ChannelHandlerContext} which this {@link SimpleChannelInboundHandler}
     *            belongs to
     * @param msg the message to handle
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupRequestPacket msg) {
        // 1. 获取群对应的 channelGroup，然后将当前用户的 channel 移除
        String groupId = msg.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);

        // 2. 构造退群响应发送给客户端
        QuitGroupResponsePacket responsePacket = new QuitGroupResponsePacket();

        if (channelGroup != null) {
            channelGroup.remove(ctx.channel());
            responsePacket.setGroupId(msg.getGroupId());
            responsePacket.setSuccess(true);
        }else {
            responsePacket.setSuccess(false);
            responsePacket.setReason(groupId + "群不存在");
        }
        ctx.writeAndFlush(responsePacket);
    }
}
