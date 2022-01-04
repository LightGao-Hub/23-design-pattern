package org.example.design.structural.proxy.dynamic;

import lombok.Getter;

/**
 *  动态代理父类
 *
 * Author: GL
 * Date: 2022-01-04
 */
public abstract class ProxyFactory<T> {
    @Getter
    private final T business; // 维护一个目标对象

    protected ProxyFactory(T business) {
        this.business = business;
    }

    // 为目标对象生成内存中的代理对象
    public abstract T getProxyInstance();
}
