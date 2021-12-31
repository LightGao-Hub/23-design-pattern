package org.example.design.behavioral.mediator.require;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *  redis实体类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public class RedisDatabase<T> implements Database<T> {
    @Getter
    private final List<T> dataset = new Vector<>(); // 数据存储

    @Override
    public void receive(T data) {
        System.out.println("Redis 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(T data) {
        receive(data); // 不同步到其它数据库
    }

    public void select() {
        System.out.println("- Redis 缓存的数据：" + this.dataset.toString());
    }
}
