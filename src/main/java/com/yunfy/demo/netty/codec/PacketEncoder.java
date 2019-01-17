package com.yunfy.demo.netty.codec;

import com.yunfy.demo.netty.protocol.Packet;
import com.yunfy.demo.netty.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author yunfy
 * @create 2019-01-17 21:23
 **/
public class PacketEncoder extends MessageToByteEncoder<Packet> {
    /**
     * Encode a message into a {@link ByteBuf}. This method will be called for each written message that can be handled
     * by this encoder.
     *
     * @param ctx    the {@link ChannelHandlerContext} which this {@link MessageToByteEncoder} belongs to
     * @param packet the message to encode
     * @param out    the {@link ByteBuf} into which the encoded message will be written
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf out) {
        PacketCodeC.INSTANCE.encode(out, packet);
    }
}
