package org.example.design.behavioral.state;

import lombok.Getter;
import org.example.design.behavioral.command.require.first.StockReceive;

/**
 *  股票状态类
 *
 * Author: GL
 * Date: 2021-11-19
 */
public abstract class StockState implements State {

    // 持有服务端引用
    @Getter
    private final StockReceive stockService;

    protected StockState(StockReceive stockService) {
        this.stockService = stockService;
    }
}
