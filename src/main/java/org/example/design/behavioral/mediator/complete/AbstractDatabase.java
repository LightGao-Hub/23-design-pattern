package org.example.design.behavioral.mediator.complete;

/**
 *  数据库父类, 需要中介类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public abstract class AbstractDatabase<T> {

    protected AbstractMediator<T> mediator;    // 中介者

    public AbstractDatabase(AbstractMediator<T> mediator) {
        this.mediator = mediator;
    }

    public abstract void addData(T data);

    public abstract void add(T data);

}
