package org.example.design.behavioral.mediator.simple;

import lombok.Getter;
import org.example.design.behavioral.mediator.complete.DatabaseType;

import java.util.List;
import java.util.Vector;

/**
 *  Redis具体同事类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public class RedisDatabase<T> extends AbstractDatabase<T> {
    @Getter
    private final List<T> dataset = new Vector<>(); // 数据存储

    protected RedisDatabase(AbstractMediator<DatabaseType, AbstractDatabase<T>> mediator) {
        super(DatabaseType.REDIS, mediator);
    }

    @Override
    public void receive(T data) {
        System.out.println("Redis 添加数据：" + data);
        dataset.add(data);
    }

    @Override
    public void forward(T data) {
    }

    public void select() {
        System.out.println("Redis 缓存的数据：" + dataset.toString());
    }
}
