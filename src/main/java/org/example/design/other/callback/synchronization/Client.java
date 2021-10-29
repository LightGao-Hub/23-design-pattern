package org.example.design.other.callback.synchronization;

/**
 * Author: GL
 * Date: 2021-10-25
 */
public interface Client<T> extends MessageCallBack<String> {

    void sendMessage(T message);

}
