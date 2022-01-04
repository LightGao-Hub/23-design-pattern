package org.example.design.behavioral.command.require.second;

import lombok.extern.log4j.Log4j2;

/**
 *  发送放: 用户股票发送方
 *
 * Author: GL
 * Date: 2021-11-05
 */
@Log4j2
public class StockUserClient extends StockClient {
    // 用户自我属性
    private final String name;

    @Override
    public void send(StockType stockType) {
        log.info(String.format("user: %s, send request: %s ", name, stockType));
        super.getStockCommand().execute(stockType);
    }

    public StockUserClient(StockCommand stockCommand, String name) {
        super(stockCommand);
        this.name = name;
    }
}
