package org.example.design.behavioral.mediator.complete;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 *  中介抽象父类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public abstract class AbstractMediator<T> {
    // 存储数据库类型及值
    @Getter
    protected final Map<DatabaseType, AbstractDatabase<T>> dataMap = new HashMap<>();

    public void register(DatabaseType database, AbstractDatabase<T> data) {
        assert database != null;
        assert data != null;
        this.dataMap.put(database, data);
    }

    public abstract void sync(DatabaseType database, T data);
}
