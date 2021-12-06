package org.example.design.behavioral.mediator.perfect;

import lombok.Getter;

/**
 *  抽象同事类, 继承AbstractDatabase接口，否则中介者类无法调用AbstractDatabase函数！
 *
 * Author: GL
 * Date: 2021-12-05
 */
public abstract class Colleague<T> extends AbstractDatabase<T> {
    @Getter
    private final AbstractMediator<T> mediator;    // 中介者

    public Colleague(AbstractMediator<T> mediator, DatabaseCommand<T> databaseCommand) {
        super(databaseCommand);
        this.mediator = mediator;
    }
}
