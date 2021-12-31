package org.example.design.behavioral.mediator.simple;

import lombok.Getter;
import org.example.design.behavioral.mediator.complete.DatabaseType;

/**
 *  数据库父类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public abstract class AbstractDatabase<T> implements Database<T> {
    @Getter
    private final DatabaseType databaseType;
    @Getter
    private final AbstractMediator<DatabaseType, AbstractDatabase<T>> mediator;

    public abstract void forward(T data); // 子类实现转发

    public void add(T data) {
        receive(data);
        forward(data);
    }

    protected AbstractDatabase(DatabaseType databaseType, AbstractMediator<DatabaseType, AbstractDatabase<T>> mediator) {
        this.databaseType = databaseType;
        this.mediator = mediator;
        this.mediator.register(databaseType, this); // 注册
    }
}
