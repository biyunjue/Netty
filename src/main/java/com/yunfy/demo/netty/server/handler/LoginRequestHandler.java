package com.yunfy.demo.netty.server.handler;

import com.yunfy.demo.netty.protocol.request.LoginRequestPacket;
import com.yunfy.demo.netty.protocol.response.LoginResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * @author yunfy
 * @create 2019-01-17 21:25
 **/
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    /**
     * <strong>Please keep in mind that this method will be renamed to
     * {@code messageReceived(ChannelHandlerContext, I)} in 5.0.</strong>
     * <p>
     * Is called for each message of type {@link LoginRequestPacket}.
     *
     * @param ctx                the {@link ChannelHandlerContext} which this {@link SimpleChannelInboundHandler}
     *                           belongs to
     * @param loginRequestPacket the message to handle
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) {
        System.out.println(new Date() + ": 收到客户端登录请求……");
        // 登录流程
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(loginRequestPacket.getVersion());
        if (valid(loginRequestPacket)) {
            loginResponsePacket.setSuccess(true);
            System.out.println(new Date() + ": 登录成功!");
        } else {
            loginResponsePacket.setReason("账号密码校验失败");
            loginResponsePacket.setSuccess(false);
            System.out.println(new Date() + ": 登录失败!");
        }
        // 登录响应
        ctx.channel().writeAndFlush(loginResponsePacket);
    }


    /**
     * 校验请求
     *
     * @param loginRequestPacket
     * @return
     */
    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}
