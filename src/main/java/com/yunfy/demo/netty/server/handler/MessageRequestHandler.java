package com.yunfy.demo.netty.server.handler;

import com.yunfy.demo.netty.protocol.request.MessageRequestPacket;
import com.yunfy.demo.netty.protocol.response.MessageResponsePacket;
import com.yunfy.demo.netty.session.Session;
import com.yunfy.demo.netty.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author yunfy
 * @create 2019-01-17 21:35
 **/
@ChannelHandler.Sharable
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

    public static final MessageRequestHandler INSTANCE = new MessageRequestHandler();

    private MessageRequestHandler() {

    }

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
        // 1.拿到消息发送方的会话信息
        Session session = SessionUtil.getSession(ctx.channel());
        if (session == null) {
            System.out.println("没有登录，强制关闭连接");
            ctx.channel().close();
        } else {
            // 2.通过消息发送方的会话信息构造要发送的消息
            MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
            messageResponsePacket.setFromUserId(session.getUserId());
            messageResponsePacket.setFromUserName(session.getUserName());
            messageResponsePacket.setMessage(messageRequestPacket.getMessage());

            // 3.拿到消息接收方的 channel
            Channel toUserChannel = SessionUtil.getChannel(messageRequestPacket.getToUserId());

            // 4.将消息发送给消息接收方
            if (toUserChannel != null && SessionUtil.hasLogin(toUserChannel)) {
                toUserChannel.writeAndFlush(messageResponsePacket);
            } else {
                System.err.println("[" + messageRequestPacket.getToUserId() + "] 不在线，发送失败!");
            }
        }
    }
}
