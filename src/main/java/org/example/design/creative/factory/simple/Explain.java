package org.example.design.creative.factory.simple;

/**
 *  简单工厂模式是类的创建模式，又叫做静态工厂方法（Static Factory Method）模式。简单工厂模式是由一个工厂对象决定创建出哪一种产品类的实例。
 *
 *      而常见的工厂模式又有很多种实现，这里总结了二种：
 *
 *      1、一对一静态简单工厂模式[参考factory1包]
 *      2、一对多静态简单工厂模式[参考factory2包]
 *      3、《Effective Java》推荐的考虑使用一对一静态工厂方法代替构造器[参考factory3包]
 *
 *      注意：在简单工厂模式中无需将Factory设置为单例模式，虽然其构造方法是私有的，但是并不需要对外提供Factory的实例[因为都是类名.静态函数调用]，故而无需使用单例+简单工厂模式
 *
 * Author: GL
 * Date: 2021-11-25
 */
public class Explain {
}
