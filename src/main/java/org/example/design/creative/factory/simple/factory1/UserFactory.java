package org.example.design.creative.factory.simple.factory1;

import java.util.Objects;

/**
 *  工厂类：此类设计成枚举更为方便安全
 *
 * Author: GL
 * Date: 2021-11-25
 */
public enum UserFactory {
    ; // 无实例

    // 静态函数
    public static User create(String name) {
        Objects.requireNonNull(name);
        return new User(name);
    }
}
