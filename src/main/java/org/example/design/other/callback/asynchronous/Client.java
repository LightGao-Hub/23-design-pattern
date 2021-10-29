package org.example.design.other.callback.asynchronous;

/**
 * Author: GL
 * Date: 2021-10-25
 */
public interface Client<T> {

    void sendMessage(T message);

}
