package org.example.design.callback.asynchronous.utils;


/**
 * Author: GL
 * Date: 2021-10-25
 */
public class AsynchronousFactory {

    public static <T> AsynchronousCallbackUtil<T> create(int poolSize, int timeOut) {
        return new AsynchronousCallbackUtil<>(poolSize, timeOut);
    }

    public static <T> AsynchronousCallbackUtil<T> create() {
        return new AsynchronousCallbackUtil<>(5, 60);
    }
}
