package org.example.design.behavioral.mediator.perfect;

import org.example.design.behavioral.mediator.complete.DatabaseType;

import java.util.Map;

/**
 *  redis命令实现类: 负责执行
 *
 * Author: GL
 * Date: 2021-11-11
 */
public class RedisCommand<T> extends DatabaseCommand<T> {

    @Override
    public void execute(Map<DatabaseType, Colleague<T>> dataMap) {
        System.out.println("redis 无需同步");
    }
}
