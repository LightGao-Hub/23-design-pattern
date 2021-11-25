package org.example.design.creative.single;

import lombok.ToString;

/**
 *  枚举实现单例，推荐！
 *  将需要单例的业务放到枚举类里，可以有自己的变量和自己的函数，并且构造方法是默认私有的！！
 *
 * Author: GL
 * Date: 2021-11-24
 */
@ToString
public enum Singleton {
    /**
     * 定义一个枚举的元素，它就代表了Singleton的一个实例。
     * 枚举元素必须要在第一行！否则会和业务的成员变量混淆报错！
     */
    INSTANCE;

    private final String name = "single";

    /**
     * 单例可以有自己的操作
     */
    public void singletonOperation() {
        System.out.println(this.toString());
    }

}
