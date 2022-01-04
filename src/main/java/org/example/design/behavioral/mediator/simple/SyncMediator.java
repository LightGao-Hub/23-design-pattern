package org.example.design.behavioral.mediator.simple;

import lombok.extern.log4j.Log4j2;
import org.example.design.behavioral.mediator.complete.DatabaseType;

/**
 *  具体中介者
 *
 * Author: GL
 * Date: 2021-11-10
 */
@Log4j2
public class SyncMediator<T> extends AbstractMediator<DatabaseType, AbstractDatabase<T>> {

    @Override
    protected void changed(DatabaseType databaseType, AbstractDatabase<T> database) {
        log.info(String.format("成功注册 - %s: %s", databaseType, database));
    }

}
