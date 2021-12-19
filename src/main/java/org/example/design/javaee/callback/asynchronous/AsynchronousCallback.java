package org.example.design.javaee.callback.asynchronous;

import lombok.Getter;


/**
 *  通过枚举单例方式，让所有使用此类都可以共享一个回调线程池资源！
 *
 * Author: GL
 * Date: 2021-12-16
 */
public enum AsynchronousCallback {
    INSTANCE;
    @Getter // 只允许获取
    private final CallbackThreadPoolFactory.CallbackThreadPool callbackThreadPool =
            CallbackThreadPoolFactory.create(10, 60);
}
