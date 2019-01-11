package com.hejian.demo.netty.serialize;


import com.hejian.demo.netty.serialize.impl.JSONSerializer;

/**
 * @author hj
 * @create 2019-01-11 11:34
 **/
public interface Serializer {


    Serializer DEFAULT = new JSONSerializer();

    /**
     * 获取具体的序列化算法标识
     */
    byte getSerializerAlogrithm();

    /**
     * java 对象转换成二进制
     */
    byte[] serialize(Object object);

    /**
     * 二进制转换成 java 对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
