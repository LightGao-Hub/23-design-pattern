package org.example.design.behavioral.memento.simple;


/**
 *  发起人接口[即需要备份状态的类需要继承此接口]：
 *      发起人角色利用一个新创建的备忘录对象将自己的内部状态存储起来
 *      发起人角色利用传入的备忘录对象来恢复自身状态
 *
 * Author: GL
 * Date: 2021-11-15
 */
public interface Originator<T> {
    // 返回一个备忘录对象
    Memento<T> createMemento();

    // 将发起人的状态恢复到备忘录对象所记录的状态
    void restoreMemento(Memento<T> memento);
}
