package org.example.design.behavioral.iterator;

/**
 *  迭代器模式是一种行为设计模式， 让你能在不暴露集合底层表现形式 （列表、 栈和树等） 的情况下遍历集合中所有的元素。
 *
 *  最典型的案例就是JDK提供的：Iterator[迭代器] 、 Iterable[所有集合必须实现的接口];
 *
 *  根据JDK的设计我们看一下最终版迭代器模式的结构：
 *
 *      集合必须实现的接口
 *       ┌────────────┐                              迭代器
 *       │ Iterable   │                           ┌───────────┐
 *       │ └iterator()│<--------------------------│ Iterator  │
 *       └────────────┘                           │ └hasNext()│
 *            ▲                                   │ └next()   │
 *            │                                   └───────────┘
 *            │                                        ▲
 *            │                                        │
 *       ┌───────────┐                                 │
 *       │ Collection│                                 │
 *       └───────────┘                                 │
 *            ▲                                        │
 *            │                                        │
 *        ┌────────┐                                   │
 *        │ List   │                                   │
 *        └────────┘                                   │
 *            ▲                                        │
 *            │                                        │
 *       ┌───────────────────────────────────┐         │
 *       │ ArrayList                         │         │
 *       │ └iterator(){}                     │         │
 *       │   └class Itr implements Iterator{}│---------┘ 内部类Itr实现Iterator的hasNext()/next()函数
 *       │     └hasNext(){}                  │
 *       │     └next(){}                     │
 *       └───────────────────────────────────┘
 *
 *  从结构中我们可以看出, Iterable内部有iterator()抽象函数，返回值为Iterator迭代器。子类ArrayList实现iterator()抽象函数，返回的是Itr内部类！此内部类实现Iterator的hasNext()/next()函数！
 *
 *  那么为何要这么设计呢？此设计引出两个问题：
 *      1、为何要加一层Iterable? 直接让ArrayList实现Iterator迭代器的hasNext()/next()函数不香吗？为何要由Iterable的iterator函数来引出Iterator迭代器?
 *      2、为何要使用内部类？直接单独建一个类继承Iterator不行吗？
 *
 *  针对这两个问题我们来看begin包下的one/two Test类。
 *
 * Author: GL
 * Date: 2021-11-08
 */
public class Explain {
}
