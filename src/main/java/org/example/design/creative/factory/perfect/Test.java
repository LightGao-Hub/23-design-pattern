package org.example.design.creative.factory.perfect;

/**
 *  此案例是单例 + 标准工厂方法模式，用于解决标准工厂方法模式创建问题[complete包]
 *
 *      此方式可以再简化成两个一对一静态简单工厂模式，但不建议，因为此设计的优势在于是基于标准工厂方法模式的升级版[工厂枚举类都继承于同一个工厂接口，实现了未来的可扩展性]
 *
 *  结构：
 *                      工厂接口                                       实体类
 *                  ┌──────────────────┐
 *                  │UserFactory       │                            ┌───────┐
 *                  │ └Person create() │--------------------------->│Person │
 *                  └──────────────────┘                            └───────┘
 *                            ▲                                         ▲
 *                    ┌───────┼───────┐                         ┌───────┼───────┐
 *      ┌──────────────────┐       ┌───────────────────┐     ┌────────┐       ┌───────┐
 *      │enum ChildFactory │       │enum ParentFactory │     │Parent  │       │Child  │
 *      │└Person create(){}│       │└Person create(){} │     └────────┘       └───────┘
 *      └──────────────────┘       └───────────────────┘
 *          单例工厂                        单例工厂
 *
 *
 *  总结：
 *      1、此模式是基于标准工厂方法模式的升级版，优势在于工厂枚举类都继承于同一个工厂接口，实现了可扩展性
 *      2、枚举单例工厂要继承通用工厂接口，使用时可以父类指向枚举工厂类，也可以单独调用枚举工厂类的实例调用
 *
 *  缺点：
 *      标准工厂方法模式只适合单一的产品的生产, 比如此案例的父母和小孩都是人类产品，但假设再来一个宠物产品，
 *      并且宠物分为猫狗两种实体，并且人类和动物形成一个组合产品形成关联约束的话，则需要用抽象工厂模式[参考abfactory包]
 *
 * Author: GL
 * Date: 2021-11-25
 */
public class Test {
    /**
     * 使用两种方式都可以：
     *  1、接口父类指向子类引用后创建
     *  2、枚举简化调用创建
     * @param args
     */
    public static void main(String[] args) {
        /*final UserFactory parentInstance = ParentFactory.INSTANCE;
        final UserFactory childInstance = ChildFactory.INSTANCE;
        System.out.println(parentInstance.create("parent"));
        System.out.println(childInstance.create("child"));*/
        System.out.println(ParentFactory.INSTANCE.create("parent"));
        System.out.println(ChildFactory.INSTANCE.create("child"));
    }
}
