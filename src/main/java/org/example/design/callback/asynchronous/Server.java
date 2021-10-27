package org.example.design.callback.asynchronous;

/**
 * Author: GL
 * Date: 2021-10-25
 */
public interface Server<T> {
    void send(T message);
}
