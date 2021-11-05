package org.example.design.behavioral.command.complex;


import org.example.design.behavioral.command.usually.one.StockReceive;

/**
 *  股票购买命令实现类
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
}
