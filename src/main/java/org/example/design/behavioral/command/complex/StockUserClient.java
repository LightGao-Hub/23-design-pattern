package org.example.design.behavioral.command.complex;

import java.util.Queue;

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
        final Queue<StockCommand> queue = super.getQueue();
        if (!queue.isEmpty()) {
            final StockCommand poll = queue.poll();
            poll.undo();
        }
    }

    public StockUserClient(String name) {
        this.name = name;
    }
}
