package org.example.design.behavioral.mediator.usually;

import java.util.ArrayList;
import java.util.List;

/**
 *  redis实体类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public class RedisDatabase<T> implements Database<T> {

    private final List<T> dataset = new ArrayList<>();

    @Override
    public void addData(T data) {
        System.out.println("Redis 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(T data) {
        addData(data); // 不同步到其它数据库
    }

    public void cache() {
        System.out.println("- Redis 缓存的数据：" + this.dataset.toString());
    }
}
