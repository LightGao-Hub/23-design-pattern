package org.example.design.behavioral.mediator.complete;

/**
 *  具体中介者
 *
 * Author: GL
 * Date: 2021-11-10
 */
public class SyncMediator<T> extends AbstractMediator<DatabaseType, T, AbstractDatabase<T>> {

    // 根据类型进行不同方式的同步
    @Override
    public void changed(DatabaseType database, T data) {
        switch (database) {
            case MYSQL:
                getDataMap().get(DatabaseType.REDIS).receive(data);
                getDataMap().get(DatabaseType.ES).receive(data);
                break;
            case REDIS:
                System.out.println("redis 无需同步");
                break;
            case ES:
                getDataMap().get(DatabaseType.MYSQL).receive(data);
                break;
            default:
                throw new RuntimeException("数据库类型错误");
        }
    }


}
