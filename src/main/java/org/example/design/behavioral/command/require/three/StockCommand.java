package org.example.design.behavioral.command.require.three;

import lombok.Getter;
import org.example.design.behavioral.command.require.two.StockReceive;

/**
 *  股票请求父类
 *
 * Author: GL
 * Date: 2021-11-05
 */
public abstract class StockCommand implements Command {
    // 持有服务端
    @Getter
    private final StockReceive stockService;

    public StockCommand(StockReceive stockService) {
        this.stockService = stockService;
    }

    public abstract void execute(StockType stockType);
}
