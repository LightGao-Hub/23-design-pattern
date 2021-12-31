package org.example.design.behavioral.mediator.simple;

import lombok.Getter;
import org.example.design.behavioral.mediator.complete.DatabaseType;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *  MYSQL具体同事类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public class MysqlDatabase<T> extends AbstractDatabase<T> {
    @Getter
    private final List<T> dataset = new CopyOnWriteArrayList<>(); // 数据存储

    protected MysqlDatabase(AbstractMediator<DatabaseType, AbstractDatabase<T>> mediator) {
        super(DatabaseType.MYSQL, mediator);
    }

    @Override
    public void receive(T data) {
        System.out.println("Mysql 添加数据：" + data);
        dataset.add(data);
    }

    @Override
    public void forward(T data) {
        getMediator().getKey(DatabaseType.ES).receive(data);
        getMediator().getKey(DatabaseType.REDIS).receive(data);
    }

    public void select() {
        System.out.println("Mysql 查询，数据：" + dataset.toString());
    }
}
