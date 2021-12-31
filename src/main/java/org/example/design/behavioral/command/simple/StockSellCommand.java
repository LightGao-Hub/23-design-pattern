package org.example.design.behavioral.command.simple;

import org.example.design.behavioral.command.require.two.StockReceive;

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
}
