package org.example.design.behavioral.mediator.simple;

import java.util.List;
import java.util.Vector;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.example.design.behavioral.mediator.complete.DatabaseType;

/**
 *  Redis具体同事类
 *
 * Author: GL
 * Date: 2021-11-10
 */
@Log4j2
public class RedisDatabase<T> extends AbstractDatabase<T> {
    @Getter
    private final List<T> dataset = new Vector<>(); // 数据存储

    protected RedisDatabase(AbstractMediator<DatabaseType, AbstractDatabase<T>> mediator) {
        super(DatabaseType.REDIS, mediator);
    }

    @Override
    public void receive(T data) {
        log.info("Redis 添加数据：" + data);
        dataset.add(data);
    }

    @Override
    public void forward(T data) {
    }

    public void select() {
        log.info("Redis 缓存的数据：" + dataset.toString());
    }
}
