package org.example.design.behavioral.memento.complete;


import org.example.design.behavioral.command.usually.one.StockReceive;
import org.example.design.behavioral.memento.simple.Memento;

/**
 *  股票购买命令实现类，实现备忘录模式的发起人接口
 *
 * Author: GL
 * Date: 2021-11-05
 */
public class StockBuyCommand extends StockCommand {

    protected StockBuyCommand(StockReceive stockService) {
        super(stockService);
    }

    @Override
    public void execute() {
        super.getStockService().buy();
    }

    @Override
    public void undo() {
        System.out.print("撤回操作-");
        super.getStockService().sell();
    }

    @Override
    public String toString() {
        return "StockBuyCommand{}";
    }

    @Override
    public Memento<StockCommand> createMemento() {
        return new Memento<>(new StockBuyCommand(super.getStockService()));
    }

    @Override
    public void restoreMemento(Memento<StockCommand> memento) {
        // 由于此命令内部不存储变量，故无需实现此函数
    }
}
