package org.example.design.behavioral.mediator.complete;

import lombok.Getter;

/**
 *  抽象同事类, 继承Database接口，否则中介者类无法调用Database接口函数！
 *
 * Author: GL
 * Date: 2021-12-05
 */
public abstract class Colleague<T> implements Database<T> {
    @Getter
    private final AbstractMediator<T> mediator;    // 中介者

    protected Colleague(AbstractMediator<T> mediator) {
        this.mediator = mediator;
    }

}
