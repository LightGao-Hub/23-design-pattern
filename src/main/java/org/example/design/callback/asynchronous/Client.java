package org.example.design.callback.asynchronous;

/**
 * Author: GL
 * Date: 2021-10-25
 */
public interface Client<T> {

    void sendMessage(T message);

}
