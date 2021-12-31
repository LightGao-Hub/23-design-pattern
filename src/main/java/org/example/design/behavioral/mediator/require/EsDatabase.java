package org.example.design.behavioral.mediator.require;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

/**
 *  ES实体类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public class EsDatabase<T> implements Database<T> {
    @Getter
    private final List<T> dataset = new LinkedList<>(); // 数据存储
    @Setter
    private Database<T> mysqlDatabase;

    @Override
    public void receive(T data) {
        System.out.println("ES 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(T data) {
        receive(data);
        this.mysqlDatabase.receive(data);   // 维护同步到MySQL的同步作业
    }

    public void select() {
        System.out.println("- Elasticsearch 统计，目前有 " + this.dataset.size() + " 条数据，数据：" + this.dataset.toString());
    }
}
