package com.yunfy.demo.netty.client.handler;

import com.yunfy.demo.netty.protocol.response.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * @author yunfy
 * @create 2019-01-17 21:38
 **/
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {
    /**
     * <strong>Please keep in mind that this method will be renamed to
     * {@code messageReceived(ChannelHandlerContext, I)} in 5.0.</strong>
     * <p>
     * Is called for each message of type {@link MessageResponsePacket}.
     *
     * @param ctx the {@link ChannelHandlerContext} which this {@link SimpleChannelInboundHandler}
     *            belongs to
     * @param messageResponsePacket the message to handle
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket messageResponsePacket) {
        System.out.println(new Date() + ": 收到服务端的消息: " + messageResponsePacket.getMessage());
    }
}
