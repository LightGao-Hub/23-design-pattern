package org.example.design.behavioral.command.require.first;

import lombok.extern.log4j.Log4j2;

/**
 *  接收方：股票经理人接收方
 *
 * Author: GL
 * Date: 2021-11-05
 */
@Log4j2
public class StockManagerReceive extends StockReceive {
    // 经理人属性
    private final String name;

    @Override
    public void buy() {
        log.info(String.format("Stock Manager-%s Successfully buy for you", name));
    }

    @Override
    public void sell() {
        log.info(String.format("Stock Manager-%s Successfully sell for you", name));
    }

    public StockManagerReceive(String name) {
        this.name = name;
    }
}
