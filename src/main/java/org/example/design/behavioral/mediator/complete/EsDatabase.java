package org.example.design.behavioral.mediator.complete;

import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;


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

    protected EsDatabase() {
        super(DatabaseType.ES);
    }

    @Override
    public void receive(T data) {
        log.info("ES 添加数据：" + data);
        dataset.add(data);
    }

    public void select() {
        log.info("Elasticsearch 统计, 目前有 " + dataset.size() + " 条数据, 数据：" + dataset.toString());
    }
}
