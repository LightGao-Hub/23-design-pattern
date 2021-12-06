package org.example.design.behavioral.mediator.perfect;

import org.example.design.behavioral.mediator.complete.DatabaseType;

import java.util.ArrayList;
import java.util.List;

/**
 *  REDIS实体类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public class ESDatabase<T> extends Colleague<T> {

    private final List<T> dataset = new ArrayList<>();

    public ESDatabase(AbstractMediator<T> mediator) {
        super(mediator, new ESCommand<>());
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
        this.getDatabaseCommand().setData(data);
        this.getMediator().changed(this.getDatabaseCommand()); // 将命令交给中介者
    }

    // 重载add！目的是实现扩展，如果用户更改了es的数据传送逻辑，只需要新建一个命令子类继承ESCommand后，通过重载add入参传输即可！
    public void add(T data, ESCommand<T> esCommand) {
        addData(data);
        esCommand.setData(data);
        this.getMediator().changed(esCommand);
    }

    public void count() {
        int count = this.dataset.size();
        System.out.println("Elasticsearch 统计，目前有 " + count + " 条数据，数据：" + this.dataset.toString());
    }
}
