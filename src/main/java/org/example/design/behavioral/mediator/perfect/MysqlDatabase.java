package org.example.design.behavioral.mediator.perfect;

import org.example.design.behavioral.mediator.complete.DatabaseType;

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
        super(mediator, new MysqlCommand<>());
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
        super.getDatabaseCommand().setData(data);
        this.getMediator().sync(super.getDatabaseCommand()); // 将命令交给中介者
    }

    // 重载add！目的是实现扩展，如果用户更改了mysql的数据传送逻辑，只需要新建一个命令子类继承MysqlCommand后，通过重载add入参传输即可！
    public void add(T data, MysqlCommand<T> mysqlCommand) {
        addData(data);
        mysqlCommand.setData(data);
        this.getMediator().sync(mysqlCommand);
    }

    public void select() {
        System.out.println("Mysql 查询，数据：" + this.dataset.toString());
    }
}
