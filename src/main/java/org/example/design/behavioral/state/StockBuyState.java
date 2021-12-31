package org.example.design.behavioral.state;

import org.example.design.behavioral.command.require.first.StockReceive;

/**
 *  股票购买状态类
 *
 * Author: GL
 * Date: 2021-11-19
 */
public class StockBuyState extends StockState {

    protected StockBuyState(StockReceive stockService) {
        super(stockService);
    }

    @Override
    public void handle() {
        super.getStockService().buy();
    }
}
