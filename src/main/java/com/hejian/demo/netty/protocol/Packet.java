package com.hejian.demo.netty.protocol;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 通信过程的抽象类
 *
 * @author hj
 * @create 2019-01-11 11:17
 **/
@Data
public abstract class Packet {
    /**
     * 协议版本
     */
    @JSONField(deserialize = false, serialize = false)
    private Byte version = 1;

    /**
     * 指令
     *
     * @return
     */
    @JSONField(serialize = false)
    public abstract Byte getCommand();
}
