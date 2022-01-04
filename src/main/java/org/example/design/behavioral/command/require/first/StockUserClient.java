package org.example.design.behavioral.command.require.first;

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
    public void buy() {
        log.info(String.format("user: %s Buy stock ", name));
        super.buy();
    }

    @Override
    public void sell() {
        log.info(String.format("user: %s Sell stock ", name));
        super.sell();
    }

    public StockUserClient(StockReceive stockService, String name) {
        super(stockService);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
