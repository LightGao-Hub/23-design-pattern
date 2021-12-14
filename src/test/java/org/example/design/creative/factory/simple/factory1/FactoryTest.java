package org.example.design.creative.factory.simple.factory1;

import org.junit.Test;

/**
 *  此案例用来实现一对一静态简单工厂模式
 *
 *      顾名思义，一对一静态简单工厂模式就是针对某个类而创建的工厂类，此工厂类包含一个静态方法用来创建针对的类
 *      此模式实现简单使用方便，可以针对不同业务类进行定制，也是常见的使用方式
 *      缺点是不方便扩展
 *
 *  结构：
 *      ┌─────────────────────┐
 *      │enum UserFactory     │          ┌─────┐
 *      │ └create(){}         │<---------│User │
 *      └─────────────────────┘          └─────┘
 *
 *  注意：UserFactory类
 *      1、此类要设计成enum枚举类，更安全
 *      2、此类是不能实现依赖倒置原则，如果实现则要继承某个Factory接口的create抽象函数再实现, 但此create函数是静态函数！接口中的函数只能是普通函数，如果实现Factory接口的create函数，实现后的只能是普通函数！
 *         外界就不能直接调用
 *
 * Author: GL
 * Date: 2021-11-25
 */
public class FactoryTest {
    @Test
    public void test() {
        System.out.println(UserFactory.create("factory"));
    }
}
