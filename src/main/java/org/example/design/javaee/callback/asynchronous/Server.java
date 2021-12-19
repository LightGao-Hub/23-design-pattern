package org.example.design.javaee.callback.asynchronous;

/**
 * Author: GL
 * Date: 2021-10-25
 */
public interface Server<T> {
    T receive(T message);
}
