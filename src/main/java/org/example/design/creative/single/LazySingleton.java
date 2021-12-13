package org.example.design.creative.single;

/**
 *  懒汉式单例
 *
 * Author: GL
 * Date: 2021-11-24
 */
public class LazySingleton {

    private static LazySingleton instance = null;

    /**
     * 私有默认构造子
     */
    private LazySingleton() {}

    /**
     * 静态工厂方法，通过synchronized解决多线程问题，但又会影响效率
     */
    public static synchronized LazySingleton getInstance() {
        if(instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
