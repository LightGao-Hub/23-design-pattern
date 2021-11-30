package org.example.design.creative.factory.simple.factory2;

import java.util.Objects;

/**
 *  工厂类：
 *      注意此设计UserFactory类是不能继承某个Factory接口的create抽象函数再实现, 因为create函数是静态函数！如果实现Factory接口的create函数，实现后的只能是普通函数！
 *      外界就不能直接调用，而是先实现后调用！
 *
 * Author: GL
 * Date: 2021-11-25
 */
public enum UserFactory {
    ; // 无实例

    // 静态函数
    public static Person create(UserType userType, String name) {
        Objects.requireNonNull(userType);
        switch (userType) {
            case USER_CHILD:
                return new Child(name);
            case USER_PARENT:
                return new Parent(name);
            default:
                throw new RuntimeException("类型不存在");
        }
    }
}
