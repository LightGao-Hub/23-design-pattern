package org.example.design.behavioral.command.complex;

import org.example.design.behavioral.command.usually.one.Client;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 发送放：股票发送接口
 *
 * Author: GL
 * Date: 2021-11-05
 */
public abstract class StockClient implements Client {
    // 命令存储队列-线程安全队列
    private final Queue<StockCommand> queue = new LinkedBlockingDeque<>();

    public abstract void send(StockCommand... stockCommand);

    public abstract void undo();

    public void select() {
        System.out.println(this.queue);
    }

    public Queue<StockCommand> getQueue() {
        return this.queue;
    }
}
