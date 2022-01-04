package org.example.design.structural.adapter;

import java.util.concurrent.Callable;

/**
 *  Callable适配到Runnable的适配器
 * Author: GL
 * Date: 2021-10-28
 */
public class RunnableAdapter implements Runnable {
    // 引用待转换接口:
    private final Callable<?> callable;

    public RunnableAdapter(Callable<?> callable) {
        this.callable = callable;
    }

    // 实现指定接口:
    public void run() {
        // 将指定接口调用委托给转换接口调用:
        try {
            callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
