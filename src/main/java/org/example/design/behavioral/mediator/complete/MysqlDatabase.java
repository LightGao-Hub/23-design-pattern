package org.example.design.behavioral.mediator.complete;

import java.util.ArrayList;
import java.util.List;

/**
 *  MYSQL实体类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public class MysqlDatabase<T> extends AbstractDatabase<T> {

    private final List<T> dataset = new ArrayList<>();

    public MysqlDatabase(AbstractMediator<T> mediator) {
        super(mediator);
        mediator.register(DatabaseType.MYSQL, this);
    }

    @Override
    public void addData(T data) {
        System.out.println("Mysql 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(T data) {
        addData(data);
        this.mediator.sync(DatabaseType.MYSQL, data); // 数据同步作业交给中介者管理
    }

    public void select() {
        System.out.println("Mysql 查询，数据：" + this.dataset.toString());
    }
}
