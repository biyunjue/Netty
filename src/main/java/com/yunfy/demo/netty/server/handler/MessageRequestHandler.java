package com.yunfy.demo.netty.server.handler;

import com.yunfy.demo.netty.protocol.request.MessageRequestPacket;
import com.yunfy.demo.netty.protocol.response.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * @author yunfy
 * @create 2019-01-17 21:35
 **/
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {
    /**
     * <strong>Please keep in mind that this method will be renamed to
     * {@code messageReceived(ChannelHandlerContext, I)} in 5.0.</strong>
     * <p>
     * Is called for each message of type {@link MessageRequestPacket}.
     *
     * @param ctx                  the {@link ChannelHandlerContext} which this {@link SimpleChannelInboundHandler}
     *                             belongs to
     * @param messageRequestPacket the message to handle
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket messageRequestPacket) {
        // 客户端发来消息
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        System.out.println(new Date() + ": 收到客户端消息: " + messageRequestPacket.getMessage());
        messageResponsePacket.setMessage("服务端回复【" + messageRequestPacket.getMessage() + "】");
        ctx.channel().writeAndFlush(messageResponsePacket);
    }
}
