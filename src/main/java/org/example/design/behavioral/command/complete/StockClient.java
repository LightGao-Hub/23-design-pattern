package org.example.design.behavioral.command.complete;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

import lombok.extern.log4j.Log4j2;
import org.example.design.behavioral.command.require.first.Client;

/**
 * 发送放：股票发送接口
 *
 * Author: GL
 * Date: 2021-11-05
 */
@Log4j2
public abstract class StockClient implements Client {
    // 命令存储队列-线程安全队列
    private final Deque<StockCommand> queue = new LinkedBlockingDeque<>();

    public abstract void send(StockCommand... stockCommand);

    public abstract void undo();

    public void select() {
        log.info(this.queue);
    }

    public Deque<StockCommand> getQueue() {
        return this.queue;
    }
}
