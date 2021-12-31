package org.example.design.behavioral.memento.complete;

import org.example.design.behavioral.command.require.two.Client;

/**
 * 发送放：股票发送接口
 *
 * Author: GL
 * Date: 2021-11-05
 */
public abstract class StockClient implements Client {
    // 备忘录模式中责任类
    private final Caretaker<StockCommand> caretaker = new Caretaker<>();

    public abstract void send(StockCommand... stockCommand);

    // 撤回最近一次操作
    public abstract void undo();

    // 撤回最近count次操作
    public abstract void undo(int count);

    public void select() {
        System.out.println(this.caretaker);
    }

    public Caretaker<StockCommand> getCaretaker() {
        return this.caretaker;
    }
}
