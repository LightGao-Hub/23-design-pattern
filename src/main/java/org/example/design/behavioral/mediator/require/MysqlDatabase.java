package org.example.design.behavioral.mediator.require;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * mysql数据库实体类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public class MysqlDatabase<T> implements Database<T> {
    @Getter
    private final List<T> dataset = new CopyOnWriteArrayList<>(); // 数据存储
    @Setter
    private Database<T> redisDatabase;
    @Setter
    private Database<T> esDatabase;

    @Override
    public void receive(T data) {
        System.out.println("Mysql 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(T data) {
        receive(data);
        this.redisDatabase.receive(data);   // 维护同步到Redis的同步作业
        this.esDatabase.receive(data);  // 维护同步到Elasticsearch的同步作业
    }

    public void select() {
        System.out.println("- Mysql 查询，数据：" + this.dataset.toString());
    }

}
