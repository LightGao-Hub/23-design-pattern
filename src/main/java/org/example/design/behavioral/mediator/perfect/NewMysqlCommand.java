package org.example.design.behavioral.mediator.perfect;

import org.example.design.behavioral.mediator.complete.DatabaseType;

import java.util.Map;

/**
 *  测试修改mysql命令的子类
 *
 * Author: GL
 * Date: 2021-11-11
 */
public class NewMysqlCommand<T> extends MysqlCommand<T> {

    @Override
    public void execute(Map<DatabaseType, Colleague<T>> dataMap) {
        dataMap.get(DatabaseType.ES).addData(super.data);
    }

}
