package com.hejian.demo.netty.protocol.command;

import com.hejian.demo.netty.serialize.Serializer;
import com.hejian.demo.netty.serialize.impl.JSONSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.util.HashMap;
import java.util.Map;

import static com.hejian.demo.netty.protocol.command.Command.LOGIN_REQUEST;

/**
 * @author hj
 * @create 2019-01-11 11:42
 **/
public class PacketCodeC {

    private static final int MAGIC_NUMBER = 0x12345678;
    /**
     * 存储所有的命令类型及对应的类
     **/
    private static final Map<Byte, Class<? extends Packet>> packetTypeMap;

    /**
     * 存储所有的序列化方式及对应的序列化类
     **/
    private static final Map<Byte, Serializer> serializerMap;

    static {
        packetTypeMap = new HashMap<>();
        packetTypeMap.put(LOGIN_REQUEST, LoginRequestPacket.class);

        serializerMap = new HashMap<>();
        Serializer serializer = new JSONSerializer();
        serializerMap.put(serializer.getSerializerAlogrithm(), serializer);
    }

    /**
     * 编码
     *
     * @param packet
     * @return
     */
    public ByteBuf encode(Packet packet) {
        // 1. 创建 ByteBuf 对象
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer();
        // 2. 序列化 java 对象
        byte[] bytes = Serializer.DEFAULT.serialize(packet);
        // 3. 实际编码过程
        // 魔数
        byteBuf.writeInt(MAGIC_NUMBER);
        // 协议版本
        byteBuf.writeByte(packet.getVersion());
        // 序列化方式
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlogrithm());
        // 指令
        byteBuf.writeByte(packet.getCommand());
        // 数据长度
        byteBuf.writeInt(bytes.length);
        // 实际数据
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }

    /**
     * 解码
     *
     * @param byteBuf
     * @return
     */
    public Packet decode(ByteBuf byteBuf) {
        // 假定传过来的数据匹配需要的数据，跳过验证
        byteBuf.skipBytes(4);
        // 跳过版本号
        byteBuf.skipBytes(1);
        // 获取序列化方式
        byte serializeAlgorithm = byteBuf.readByte();
        // 获取指令
        byte command = byteBuf.readByte();
        // 数据包长度
        int length = byteBuf.readInt();

        //获取实际的数据
        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);

        Class<? extends Packet> requestType = getRequestType(command);
        Serializer serializer = getSerializer(serializeAlgorithm);
        if (requestType != null && serializer != null) {
            return serializer.deserialize(requestType, bytes);
        }
        return null;
    }

    /**
     * 获取对应的序列化方式
     *
     * @param serializeAlgorithm
     * @return
     */
    private Serializer getSerializer(byte serializeAlgorithm) {

        return serializerMap.get(serializeAlgorithm);
    }

    /**
     * 获取对应的命令请求
     *
     * @param command
     * @return
     */
    private Class<? extends Packet> getRequestType(byte command) {
        return packetTypeMap.get(command);
    }
}
