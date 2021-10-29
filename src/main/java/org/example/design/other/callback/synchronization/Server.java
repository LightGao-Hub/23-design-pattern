package org.example.design.other.callback.synchronization;

/**
 * Author: GL
 * Date: 2021-10-25
 */
public interface Server<T> {
    void send(T message, Client<T> messageClient);
}
