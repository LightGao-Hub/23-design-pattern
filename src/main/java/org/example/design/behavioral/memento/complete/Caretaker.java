package org.example.design.behavioral.memento.complete;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.IntStream;

import lombok.ToString;
import org.example.design.behavioral.memento.simple.Memento;

/**
 *  负责人角色类：
 *      股票案例中撤回后不可再恢复到撤回前的状态
 *
 * Author: GL
 * Date: 2021-11-15
 */
@ToString
public class Caretaker<T> {
    private final Deque<Memento<T>> mementos = new LinkedBlockingDeque<>();

    public synchronized void saveMemento(Memento<T> memento) {
        mementos.add(memento);
    }

    // 取最近一次的备份
    public Memento<T> retrieveMemento() {
        return mementos.pollLast();
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
