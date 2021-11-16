package org.example.design.behavioral.command.complete;

import java.util.Deque;

/**
 * 发送放: 用户股票发送方
 * <p>
 * Author: GL
 * Date: 2021-11-05
 */
public class StockUserClient extends StockClient {

    // 用户自我属性
    private final String name;

    // 记录命令及请求操作
    // 注意：此处的记录命令并不是快照方式，而是将原有的引用放进队列，此时如果命令修改，则队列中的元素也会修改，并不会起到快照作用，所以此处有漏洞，解决参考备忘录模式
    @Override
    public void send(StockCommand... stockCommand) {
        for (StockCommand command : stockCommand) {
            super.getQueue().add(command);
            command.execute();
        }
    }

    // 撤回操作
    @Override
    public void undo() {
        final Deque<StockCommand> queue = super.getQueue();
        if (!queue.isEmpty()) {
            final StockCommand stockCommand = queue.pollLast();
            stockCommand.undo();
        }
    }

    public StockUserClient(String name) {
        this.name = name;
    }
}
