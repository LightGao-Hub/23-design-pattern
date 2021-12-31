package org.example.design.behavioral.mediator.complete;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *  MYSQL具体同事类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public class MysqlDatabase<T> extends AbstractDatabase<T> {

    @Getter
    private final List<T> dataset = new CopyOnWriteArrayList<>(); // 数据存储

    protected MysqlDatabase() {
        super(DatabaseType.MYSQL);
    }

    @Override
    public void receive(T data) {
        System.out.println("Mysql 添加数据：" + data);
        dataset.add(data);
    }

    public void select() {
        System.out.println("Mysql 查询，数据：" + dataset.toString());
    }
}
