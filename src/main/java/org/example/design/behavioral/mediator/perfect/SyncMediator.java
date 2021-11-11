package org.example.design.behavioral.mediator.perfect;


/**
 *  具体中介者
 *
 * Author: GL
 * Date: 2021-11-10
 */
public class SyncMediator<T> extends AbstractMediator<T> {

    // 此时无需根据类型判断，直接调用命令类函数即可！
    @Override
    public void sync(DatabaseCommand<T> command) {
        command.execute(super.getDataMap());
    }
}
