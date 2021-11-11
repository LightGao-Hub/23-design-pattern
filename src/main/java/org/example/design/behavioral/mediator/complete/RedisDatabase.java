package org.example.design.behavioral.mediator.complete;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: GL
 * Date: 2021-11-10
 */
public class RedisDatabase<T> extends AbstractDatabase<T> {

    private final List<T> dataset = new LinkedList<>();

    public RedisDatabase(AbstractMediator<T> mediator) {
        super(mediator);
        mediator.register(DatabaseType.REDIS, this);
    }

    @Override
    public void addData(T data) {
        System.out.println("Redis 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(T data) {
        addData(data);
        this.mediator.sync(DatabaseType.REDIS, data);    // 数据同步作业交给中介者管理
    }

    public void cache() {
        System.out.println("Redis 缓存的数据：" + this.dataset.toString());
    }
}
