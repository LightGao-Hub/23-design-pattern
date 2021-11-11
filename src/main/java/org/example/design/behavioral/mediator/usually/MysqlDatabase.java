package org.example.design.behavioral.mediator.usually;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * mysql数据库实体类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public class MysqlDatabase<T> extends AbstractDatabase<T> {

    private final List<T> dataset = new ArrayList<>();
    @Setter
    private AbstractDatabase<T> redisDatabase;
    @Setter
    private AbstractDatabase<T> esDatabase;

    @Override
    public void addData(T data) {
        System.out.println("Mysql 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(T data) {
        addData(data);
        this.redisDatabase.addData(data);   // 维护同步到Redis的同步作业
        this.esDatabase.addData(data);  // 维护同步到Elasticsearch的同步作业
    }

    public void select() {
        System.out.println("- Mysql 查询，数据：" + this.dataset.toString());
    }

}
