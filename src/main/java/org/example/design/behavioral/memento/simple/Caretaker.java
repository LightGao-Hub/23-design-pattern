package org.example.design.behavioral.memento.simple;

import lombok.ToString;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *  负责人角色类，负责人角色类负责保存备忘录对象，但是从不修改（甚至不查看）备忘录对象的内容。
 *
 * Author: GL
 * Date: 2021-11-15
 */
@ToString
public class Caretaker<T> {
    // 线程安全列表, 不对外开放
    private final List<Memento<T>> mementos = new CopyOnWriteArrayList<>();
    private int currentIndex;

    // 备忘录的赋值方法
    public synchronized int saveMemento(Memento<T> memento) {
        this.mementos.add(memento);
        return this.currentIndex++;
    }

    // 备忘录取最近一次的备份
    public Memento<T> retrieveMemento() {
        return this.mementos.get(currentIndex-1);
    }

    // 重载-取出第几次备份
    public Memento<T> retrieveMemento(int index) {
        return this.mementos.get(index);
    }

}
