package org.example.design.behavioral.mediator.complete;

/**
 *  具体中介者
 *
 * Author: GL
 * Date: 2021-11-10
 */
public class SyncMediator<T> extends AbstractMediator<T> {

    // 根据类型进行不同方式的同步
    @Override
    public void sync(DatabaseType database, T data) {
        switch (database) {
            case MYSQL:
                super.getDataMap().get(DatabaseType.REDIS).addData(data);
                super.getDataMap().get(DatabaseType.ES).addData(data);
                break;
            case REDIS:
                System.out.println("redis 无需同步");
                break;
            case ES:
                super.getDataMap().get(DatabaseType.MYSQL).addData(data);
                break;
            default:
                throw new RuntimeException("数据库类型错误");
        }
    }
}
