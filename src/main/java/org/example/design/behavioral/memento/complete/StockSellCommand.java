package org.example.design.behavioral.memento.complete;

import org.example.design.behavioral.command.require.first.StockReceive;
import org.example.design.behavioral.memento.simple.Memento;

/**
 *  股票抛售命令实现类, 实现备忘录模式的发起人接口
 *
 * Author: GL
 * Date: 2021-11-05
 */
public class StockSellCommand extends StockCommand {

    protected StockSellCommand(StockReceive stockService) {
        super(stockService);
    }

    @Override
    public void execute() {
        super.getStockService().sell();
    }

    @Override
    public void undo() {
        System.out.print("撤回操作-");
        super.getStockService().buy();
    }

    @Override
    public String toString() {
        return "StockSellCommand{}";
    }

    @Override
    public Memento<StockCommand> createMemento() {
        return new Memento<>(this.clone());
    }

    @Override
    protected StockSellCommand clone() {
        try {
            return (StockSellCommand)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void restoreMemento(Memento<StockCommand> memento) {
        // 由于此命令内部不存储变量，故无需实现此函数
    }
}
