package org.example.design.behavioral.mediator.complete;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Author: GL
 * Date: 2021-11-10
 */
public class EsDatabase<T> extends AbstractDatabase<T> {

    private final List<T> dataset = new CopyOnWriteArrayList<>();

    public EsDatabase(AbstractMediator<T> mediator) {
        super(mediator);
        mediator.register(DatabaseType.ES, this);
    }

    @Override
    public void addData(T data) {
        System.out.println("ES 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(T data) {
        addData(data);
        this.mediator.sync(DatabaseType.ES, data);    // 数据同步作业交给中介者管理
    }

    public void count() {
        int count = this.dataset.size();
        System.out.println("Elasticsearch 统计，目前有 " + count + " 条数据，数据：" + this.dataset.toString());
    }
}
