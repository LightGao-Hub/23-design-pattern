package org.example.design.creative.factory.simple.factory2;

/**
 *  此案例用来实现一对多静态简单工厂模式
 *
 *      顾名思义，一对多静态简单工厂模式就是针对多个类而创建的工厂类，此工厂类包含一个静态方法通过传参来创建对应的类
 *      缺点是静态函数中会冗余大量逻辑
 *      解决参考[complete]
 *
 *  结构：
 *             静态工厂类                               枚举类
 *     ┌───────────────────────────────────┐
 *     │UserFactory                        │       ┌────────────┐
 *     │  └static Person create(UserType)  │------>│UserType    │
 *     └────────────│──────────────────────┘       │└USER_PARENT│
 *                  │                              │└USER_CHILD │
 *                  │                              └────────────┘
 *                  │
 *                  │                               ┌───────┐
 *                  └------------------------------>│Person │   实体类
 *                                                  └───────┘
 *                                                      ▲
 *                                              ┌───────┼───────┐
 *                                         ┌────────┐       ┌───────┐
 *                                         │Parent  │       │Child  │
 *                                         └────────┘       └───────┘
 *
 *  注意：UserFactory类
 *        1、此类要设计成final class不被继承
 *        2、此类要私有化构造函数，避免被他人创建
 *        3、此类不能继承某个Factory接口的create抽象函数再实现, 因为create函数是静态函数！接口中的函数只能是普通函数，如果实现Factory接口的create函数，实现后的只能是普通函数！
 *           外界就不能直接调用
 *        4、create函数返回的类型要是Parent 和 Child 的共同父类
 *
 * Author: GL
 * Date: 2021-11-25
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(UserFactory.create(UserType.USER_PARENT, "parent"));
        System.out.println(UserFactory.create(UserType.USER_CHILD, "child"));
    }
}
