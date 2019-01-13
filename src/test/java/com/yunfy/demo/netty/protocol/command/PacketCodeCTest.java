package com.yunfy.demo.netty.protocol.command;

import com.yunfy.demo.netty.protocol.Packet;
import com.yunfy.demo.netty.protocol.PacketCodeC;
import com.yunfy.demo.netty.protocol.request.LoginRequestPacket;
import com.yunfy.demo.netty.serialize.Serializer;
import com.yunfy.demo.netty.serialize.impl.JSONSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.junit.Assert;
import org.junit.Test;


public class PacketCodeCTest {

    @Test
    public void encodeAndDecode() {
        Serializer serializer = new JSONSerializer();
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setVersion(((byte) 1));
        loginRequestPacket.setUserId("123");
        loginRequestPacket.setUsername("zhangsan");
        loginRequestPacket.setPassword("password");

        PacketCodeC packetCodeC = PacketCodeC.INSTANCE;
        ByteBuf byteBuf = packetCodeC.encode(ByteBufAllocator.DEFAULT, loginRequestPacket);
        Packet decodedPacket = packetCodeC.decode(byteBuf);

        Assert.assertArrayEquals(serializer.serialize(loginRequestPacket), serializer.serialize(decodedPacket));
    }

}