package org.example.design.behavioral.mediator.perfect;

import org.example.design.behavioral.mediator.complete.DatabaseType;

import java.util.ArrayList;
import java.util.List;

/**
 *  REDIS实现类
 *
 * Author: GL
 * Date: 2021-11-10
 */
public class RedisDatabase<T> extends Colleague<T> {

    private final List<T> dataset = new ArrayList<>();

    public RedisDatabase(AbstractMediator<T> mediator) {
        super(mediator, new RedisCommand<>());
        mediator.register(DatabaseType.REDIS, this);
    }

    @Override
    public void addData(T data) {
        System.out.println("Redis 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(T data) {
        addData(data);
        this.getDatabaseCommand().setData(data);
        this.getMediator().changed(super.getDatabaseCommand()); // 将命令交给中介者
    }

    // 重载add！目的是实现扩展，如果用户更改了redis的数据传送逻辑，只需要新建一个命令子类继承RedisCommand后，通过重载add入参传输即可！
    public void add(T data, RedisCommand<T> redisCommand) {
        addData(data);
        redisCommand.setData(data);
        this.getMediator().changed(redisCommand);
    }

    public void cache() {
        System.out.println("Redis 缓存的数据：" + this.dataset.toString());
    }
}
