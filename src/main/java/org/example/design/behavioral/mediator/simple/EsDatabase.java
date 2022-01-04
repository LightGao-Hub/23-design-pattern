package org.example.design.behavioral.mediator.simple;

import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.example.design.behavioral.mediator.complete.DatabaseType;


/**
 *  ES具体同事类
 *
 * Author: GL
 * Date: 2021-11-10
 */
@Log4j2
public class EsDatabase<T> extends AbstractDatabase<T> {
    @Getter
    private final List<T> dataset = new LinkedList<>(); // 数据存储

    protected EsDatabase(AbstractMediator<DatabaseType, AbstractDatabase<T>> mediator) {
        super(DatabaseType.ES, mediator);
    }

    @Override
    public void receive(T data) {
        log.info("ES 添加数据：" + data);
        dataset.add(data);
    }

    @Override
    public void forward(T data) {
        getMediator().getKey(DatabaseType.MYSQL).receive(data);
    }

    public void select() {
        log.info("Elasticsearch 统计, 目前有 " + dataset.size() + " 条数据, 数据：" + dataset.toString());
    }
}
