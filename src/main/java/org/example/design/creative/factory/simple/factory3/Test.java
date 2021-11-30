package org.example.design.creative.factory.simple.factory3;

/**
 *  类的创建通过自身的一对一静态工厂方式进行创建，建议所有类都推荐使用此方式来创建对象
 *
 *  好处：
 *      1、静态工厂方法与构造器不同的第一优势在于，它们有名字。此方式可以自定义多种静态名称，可以让创建对象过程见名知意！
 *      2、不用每次使用时都创建新对象，而是通过静态函数返回对象即可
 *
 *  结构：
 *                                      ┌───────┐
 *                                      │Person │
 *                                      │└name  │
 *                                      └───────┘
 *                                          ▲
 *                   ┌──────────────────────┼──────────────────────┐
 *  ┌───────────────────────────────┐                ┌───────────────────────────────┐
 *  │Parent                         │                │Child                          │
 *  │└static Parent getInstance(){} │                │ └static Child getInstance(){} │
 *  └───────────────────────────────┘                └───────────────────────────────┘
 *
 *  总结：
 *      1、在springboot中我们可以利用spring的ico容器的方式从容器中获取即可，无需通过此静态工厂模式创建
 *      2、若不使用ico容器，则建议所有类都推荐使用此方式来创建对象
 *
 * Author: GL
 * Date: 2021-11-30
 */
public class Test {
    public static void main(String[] args) {
        final Child child = Child.getInstance("child");
        final Parent parent = Parent.getInstance("parent");
        System.out.println(child);
        System.out.println(parent);
    }
}
