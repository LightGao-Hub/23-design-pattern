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
public abstract class AbstractMediator<E> {
    // 存储数据库类型及值
    @Getter
    protected final Map<DatabaseType, Colleague<E>> dataMap = new HashMap<>();

    public void register(DatabaseType database, Colleague<E> colleague) {
        assert database != null;
        assert colleague != null;
        this.dataMap.put(database, colleague);
    }

    public abstract void changed(DatabaseType database, E data);
}
