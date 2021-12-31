package org.example.design.behavioral.mediator.simple;


import lombok.Getter;
import org.example.design.behavioral.mediator.complete.DatabaseType;

import java.util.LinkedList;
import java.util.List;

/**
 *  ES具体同事类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public class EsDatabase<T> extends AbstractDatabase<T> {
    @Getter
    private final List<T> dataset = new LinkedList<>(); // 数据存储

    protected EsDatabase(AbstractMediator<DatabaseType, AbstractDatabase<T>> mediator) {
        super(DatabaseType.ES, mediator);
    }

    @Override
    public void receive(T data) {
        System.out.println("ES 添加数据：" + data);
        dataset.add(data);
    }

    @Override
    public void forward(T data) {
        getMediator().getKey(DatabaseType.MYSQL).receive(data);
    }

    public void select() {
        System.out.println("Elasticsearch 统计，目前有 " + dataset.size() + " 条数据，数据：" + dataset.toString());
    }
}
