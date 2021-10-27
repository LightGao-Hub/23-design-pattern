package org.example.design.callback.synchronization;

/**
 * Author: GL
 * Date: 2021-10-25
 */
public interface Server<T> {
    void send(T message, Client<T> messageClient);
}
