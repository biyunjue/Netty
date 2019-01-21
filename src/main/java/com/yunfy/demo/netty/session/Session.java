package com.yunfy.demo.netty.session;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yunfy
 * @create 2019-01-21 21:31
 **/
@Data
@NoArgsConstructor
public class Session {
    /**
     * 用户标识
     */
    private String userId;
    /**
     * 用户名
     */
    private String userName;

    public Session(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return userId + ":" + userName;
    }
}
