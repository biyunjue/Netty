package com.yunfy.demo.netty.codec;

import com.yunfy.demo.netty.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * 拆包粘包
 *
 * @author yunfy
 * @create 2019-01-18 20:12
 **/
public class Spliter extends LengthFieldBasedFrameDecoder {
    /**
     * 长度域偏移量
     */
    private static final int LENGTH_FIELD_OFFSET = 7;
    /**
     * 长度域长度
     */
    private static final int LENGTH_FIELD_LENGTH = 4;

    public Spliter() {
        super(Integer.MAX_VALUE, LENGTH_FIELD_OFFSET, LENGTH_FIELD_LENGTH);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        //判断是否允许的协议
        if (in.getInt(in.readerIndex()) != PacketCodeC.MAGIC_NUMBER) {
            ctx.channel().close();
            return null;
        }

        return super.decode(ctx, in);
    }
}
