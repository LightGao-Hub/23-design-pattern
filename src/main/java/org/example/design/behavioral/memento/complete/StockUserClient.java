package org.example.design.behavioral.memento.complete;

import org.example.design.behavioral.memento.simple.Memento;

import java.util.List;

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
            super.getCaretaker().saveMemento(command.createMemento());
            command.execute();
        }
    }

    // 撤回操作
    @Override
    public void undo() {
        final Caretaker<StockCommand> caretaker = super.getCaretaker();
        final Memento<StockCommand> stockCommandMemento = caretaker.retrieveMemento();
        assert stockCommandMemento != null;
        stockCommandMemento.getState().undo();
    }

    // 由于是撤销最近几次操作，故先获得备忘录中倒序获取的备忘录，循环撤回即可
    @Override
    public void undo(int count) {
        final List<Memento<StockCommand>> mementos = super.getCaretaker().reverseMementos(count);
        mementos.forEach(m -> m.getState().undo());
    }

    public StockUserClient(String name) {
        this.name = name;
    }
}
