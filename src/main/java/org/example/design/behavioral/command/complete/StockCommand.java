package org.example.design.behavioral.command.complete;

import org.example.design.behavioral.command.require.first.StockReceive;

/**
 *  股票请求抽象父类
 *
 * Author: GL
 * Date: 2021-11-05
 */
public abstract class StockCommand implements Command {
    // 持有服务端
    private final StockReceive stockService;

    protected StockCommand(StockReceive stockService) {
        this.stockService = stockService;
    }

    public StockReceive getStockService() {
        return this.stockService;
    }
}
