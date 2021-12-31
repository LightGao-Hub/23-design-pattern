package org.example.design.behavioral.mediator.simple;

import org.example.design.behavioral.mediator.complete.DatabaseType;

/**
 *  具体中介者
 *
 * Author: GL
 * Date: 2021-11-10
 */
public class SyncMediator<T> extends AbstractMediator<DatabaseType, AbstractDatabase<T>> {

    @Override
    protected void changed(DatabaseType databaseType, AbstractDatabase<T> database) {
        System.out.println(String.format("成功注册 - %s: %s", databaseType, database));
    }

}
