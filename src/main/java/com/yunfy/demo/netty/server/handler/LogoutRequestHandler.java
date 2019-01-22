package com.yunfy.demo.netty.server.handler;

import com.yunfy.demo.netty.protocol.request.LogoutRequestPacket;
import com.yunfy.demo.netty.protocol.response.LogoutResponsePacket;
import com.yunfy.demo.netty.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author yunfy
 * @create 2019-01-22 22:18
 **/
public class LogoutRequestHandler extends SimpleChannelInboundHandler<LogoutRequestPacket> {
    /**
     * <strong>Please keep in mind that this method will be renamed to
     * {@code messageReceived(ChannelHandlerContext, I)} in 5.0.</strong>
     * <p>
     * Is called for each message of type {@link LogoutRequestPacket}.
     *
     * @param ctx the {@link ChannelHandlerContext} which this {@link SimpleChannelInboundHandler}
     *            belongs to
     * @param logoutRequestPacket the message to handle
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutRequestPacket logoutRequestPacket) {
        SessionUtil.unBindSession(ctx.channel());
        LogoutResponsePacket logoutResponsePacket = new LogoutResponsePacket();
        logoutResponsePacket.setSuccess(true);
        ctx.channel().writeAndFlush(logoutResponsePacket);
    }
}
