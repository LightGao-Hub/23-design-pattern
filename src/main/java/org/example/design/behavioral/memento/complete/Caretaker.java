package org.example.design.behavioral.memento.complete;

import lombok.ToString;
import org.example.design.behavioral.memento.simple.Memento;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.IntStream;

/**
 *  负责人角色类
 *      注意：此备忘录是为了适配此命令模式下的撤回操作，如果撤回则最近一次记录销毁，故此处使用队列存储！
 *
 * Author: GL
 * Date: 2021-11-15
 */
@ToString
public class Caretaker<T> {
    // 线程安全队列, 不对外开放
    private final Deque<Memento<T>> mementos = new LinkedBlockingDeque<>();

    // 备忘录的赋值方法
    public synchronized void saveMemento(Memento<T> memento) {
        this.mementos.add(memento);
    }

    // 备忘录取最近一次的备份
    public Memento<T> retrieveMemento() {
        return this.mementos.pollLast();
    }

    // 重载：从后向前取出n次的备份, 包括index
    public List<Memento<T>> reverseMementos(int size) {
        if (size <= mementosSize()) {
            List<Memento<T>> list = new ArrayList<>();
            IntStream.range(0, size).forEach(v -> list.add(retrieveMemento()));
            return list;
        }
        throw new RuntimeException("超出队列最大长度");
    }

    public int mementosSize() {
        return this.mementos.size();
    }
}
