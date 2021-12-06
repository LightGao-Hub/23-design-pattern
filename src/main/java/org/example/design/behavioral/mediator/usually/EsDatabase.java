package org.example.design.behavioral.mediator.usually;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 *  ES实体类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public class EsDatabase<T> implements Database<T> {

    private final List<T> dataset = new ArrayList<>();
    @Setter
    private Database<T> mysqlDatabase;

    @Override
    public void addData(T data) {
        System.out.println("ES 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(T data) {
        addData(data);
        this.mysqlDatabase.addData(data);   // 维护同步到MySQL的同步作业
    }

    public void count() {
        int count = this.dataset.size();
        System.out.println("- Elasticsearch 统计，目前有 " + count + " 条数据，数据：" + this.dataset.toString());
    }
}
