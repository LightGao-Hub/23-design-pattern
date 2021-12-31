package org.example.design.behavioral.command.complete;

import org.example.design.behavioral.command.require.first.StockReceive;

/**
 *  股票抛售命令实现类
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
}
