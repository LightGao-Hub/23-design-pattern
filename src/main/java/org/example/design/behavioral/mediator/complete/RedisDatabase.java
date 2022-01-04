package org.example.design.behavioral.mediator.complete;

import java.util.List;
import java.util.Vector;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

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

    protected RedisDatabase() {
        super(DatabaseType.REDIS);
    }

    @Override
    public void receive(T data) {
        log.info("Redis 添加数据：" + data);
        dataset.add(data);
    }

    public void select() {
        log.info("Redis 缓存的数据：" + dataset.toString());
    }
}
