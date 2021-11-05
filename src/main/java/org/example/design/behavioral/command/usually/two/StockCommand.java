package org.example.design.behavioral.command.usually.two;

import org.example.design.behavioral.command.usually.one.StockReceive;

/**
 *  股票请求实现类
 *
 * Author: GL
 * Date: 2021-11-05
 */
public class StockCommand implements Command {
    // 持有服务端
    private final StockReceive stockService;

    public StockCommand(StockReceive stockService) {
        this.stockService = stockService;
    }

    public void execute(StockType stockType) {
        switch (stockType) {
            case BUY:
                stockService.buy();
                break;
            case SELL:
                stockService.sell();
                break;
            default:
                throw new RuntimeException(" 请求类型异常 ");
        }
    }

}
