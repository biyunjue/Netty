package com.hejian.demo.netty.serialize.impl;

import com.alibaba.fastjson.JSON;
import com.hejian.demo.netty.serialize.Serializer;
import com.hejian.demo.netty.serialize.SerializerAlogrithm;

/**
 * @author hj
 * @create 2019-01-11 11:37
 **/
public class JSONSerializer implements Serializer {

    /**
     * 获取具体的序列化算法标识
     */
    @Override
    public byte getSerializerAlogrithm() {
        return SerializerAlogrithm.JSON;
    }

    /**
     * java 对象转换成二进制
     *
     * @param object
     */
    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    /**
     * 二进制转换成 java 对象
     *
     * @param clazz
     * @param bytes
     */
    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
