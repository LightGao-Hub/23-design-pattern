package org.example.design.behavioral.state;

import org.example.design.behavioral.command.require.two.StockReceive;

/**
 *  股票购买状态类
 *
 * Author: GL
 * Date: 2021-11-19
 */
public class StockSellState extends StockState {

    protected StockSellState(StockReceive stockService) {
        super(stockService);
    }

    @Override
    public void handle() {
        super.getStockService().sell();
    }
}
