package org.example.design.behavioral.mediator.require;

import java.util.List;
import java.util.Vector;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

/**
 *  redis实体类
 *
 * Author: GL
 * Date: 2021-11-10
 */
@Log4j2
public class RedisDatabase<T> implements Database<T> {
    @Getter
    private final List<T> dataset = new Vector<>(); // 数据存储

    @Override
    public void receive(T data) {
        log.info("Redis 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(T data) {
        receive(data); // 不同步到其它数据库
    }

    public void select() {
        log.info("- Redis 缓存的数据：" + this.dataset.toString());
    }
}
