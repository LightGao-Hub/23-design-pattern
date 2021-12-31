package org.example.design.behavioral.mediator.complete;

import lombok.Getter;

/**
 *  数据库父类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public abstract class AbstractDatabase<T> extends Colleague<DatabaseType, T> implements Database<T> {
    @Getter
    private final DatabaseType databaseType; // 数据库类型

    public void add(T data) {
        receive(data);
        getMediator().changed(databaseType, data);
    }

    protected AbstractDatabase(DatabaseType databaseType) {
        this.databaseType = databaseType;
    }
}
