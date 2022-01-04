package org.example.design.creative.single;

import lombok.extern.log4j.Log4j2;

/**
 *  静态内部类实现单例
 *
 * Author: GL
 * Date: 2021-11-24
 */
@Log4j2
public final class StaticSingleton {

    private StaticSingleton() {
        log.info("构建StaticSingleton");
    }

    /**
     * private修饰避免被外部调用的内部类, 也就是静态的成员式内部类, 该内部类的实例与外部类的实例
     * 没有绑定关系, 而且只有被调用到时才会装载, 从而实现了延迟加载.
     */
    private static class SingletonHolder {
        /**
         * 静态初始化器, 由JVM来保证线程安全
         */
        private static final StaticSingleton INSTANCE = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
