package org.example.design.creative.single;

/**
 *  饿汉式单例
 *
 * Author: GL
 * Date: 2021-11-24
 */
public class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    /**
     * 私有默认构造子
     */
    private EagerSingleton(){
    }

    /**
     * 静态工厂方法
     */
    public static EagerSingleton getInstance(){
        return instance;
    }
}
