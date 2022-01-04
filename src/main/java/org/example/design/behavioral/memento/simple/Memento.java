package org.example.design.behavioral.memento.simple;

import lombok.Getter;
import lombok.ToString;

/**
 *  备忘录类, 用来实现保存状态功能；备忘录对象将发起人对象传入的状态存储起来.
 *
 * Author: GL
 * Date: 2021-11-15
 */
@ToString
public class Memento<T> {
    @Getter
    private final T state;

    public Memento(T state) {
        this.state = state;
    }
}
