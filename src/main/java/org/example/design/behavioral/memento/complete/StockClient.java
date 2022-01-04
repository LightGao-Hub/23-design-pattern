package org.example.design.behavioral.memento.complete;

import java.util.List;
import java.util.Objects;

import lombok.extern.log4j.Log4j2;
import org.example.design.behavioral.command.require.first.Client;
import org.example.design.behavioral.memento.simple.Memento;

/**
 * 发送放：股票发送接口
 *
 * Author: GL
 * Date: 2021-11-05
 */
@Log4j2
public abstract class StockClient implements Client {
    // 备忘录模式中责任类
    private final Caretaker<StockCommand> caretaker = new Caretaker<>();

    public abstract void send(StockCommand... stockCommand);

    // 撤回最近一次操作
    public void undo() {
        Memento<StockCommand> stockCommandMemento = caretaker.retrieveMemento();
        Objects.requireNonNull(stockCommandMemento, "stockCommandMemento is null");
        stockCommandMemento.getState().undo();
    }

    // 撤回最近count次操作
    public void undo(int count) {
        List<Memento<StockCommand>> mementos = caretaker.reverseMementos(count);
        mementos.forEach(m -> m.getState().undo());
    }

    public void select() {
        log.info(this.caretaker);
    }

    public Caretaker<StockCommand> getCaretaker() {
        return this.caretaker;
    }
}
