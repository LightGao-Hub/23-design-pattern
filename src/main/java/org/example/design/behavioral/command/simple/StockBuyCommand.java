package org.example.design.behavioral.command.simple;

import org.example.design.behavioral.command.require.two.StockReceive;

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
}
