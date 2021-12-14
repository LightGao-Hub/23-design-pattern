package org.example.design.creative.single;

import org.junit.Test;

/**
 * Author: GL
 * Date: 2021-12-13
 */
public class SingleTest {

    // 枚举单例测试
    @Test
    public void singletonTest() {
        final Singleton uniqueInstance = Singleton.INSTANCE;
        final Singleton uniqueInstance2 = Singleton.INSTANCE;
        uniqueInstance.singletonOperation();
        uniqueInstance2.singletonOperation();
        System.out.println(uniqueInstance == uniqueInstance2); // 验证是否单例
    }

    // 静态内部类单例测试
    @Test
    public void staticSingletonTest() {
        StaticSingleton.getInstance();
    }
}
