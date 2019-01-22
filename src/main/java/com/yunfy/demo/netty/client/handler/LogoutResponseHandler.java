package com.yunfy.demo.netty.client.handler;

import com.yunfy.demo.netty.protocol.response.LogoutResponsePacket;
import com.yunfy.demo.netty.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author yunfy
 * @create 2019-01-22 22:13
 **/
public class LogoutResponseHandler extends SimpleChannelInboundHandler<LogoutResponsePacket> {

    /**
     * <strong>Please keep in mind that this method will be renamed to
     * {@code messageReceived(ChannelHandlerContext, I)} in 5.0.</strong>
     * <p>
     * Is called for each message of type {@link LogoutResponsePacket}.
     *
     * @param ctx the {@link ChannelHandlerContext} which this {@link SimpleChannelInboundHandler}
     *            belongs to
     * @param logoutResponsePacket the message to handle
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutResponsePacket logoutResponsePacket) {
        SessionUtil.unBindSession(ctx.channel());
    }
}
