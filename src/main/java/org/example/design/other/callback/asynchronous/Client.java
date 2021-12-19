package org.example.design.other.callback.asynchronous;

import lombok.Getter;

/**
 *  客户端父类
 *
 * Author: GL
 * Date: 2021-10-25
 */
public abstract class Client<T> {
    @Getter
    private final Server<T> server;

    protected Client(Server<T> server) {
        this.server = server;
    }

    public abstract void sendMessage(T message);
}
