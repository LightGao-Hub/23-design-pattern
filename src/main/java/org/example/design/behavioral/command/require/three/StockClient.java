package org.example.design.behavioral.command.require.three;

import org.example.design.behavioral.command.require.two.Client;

/**
 *  发送放：股票发送放
 *
 * Author: GL
 * Date: 2021-11-05
 */
public abstract class StockClient implements Client {
    // 持有请求引用
    private final StockCommand stockCommand;

    // 请求改为stockCommand
    public abstract void send(StockType stockType);

    public StockClient(StockCommand stockCommand) {
        this.stockCommand = stockCommand;
    }

    public StockCommand getStockCommand() {
        return this.stockCommand;
    }
}
