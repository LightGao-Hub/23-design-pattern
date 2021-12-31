package org.example.design.behavioral.command.require.three;

import org.example.design.behavioral.command.require.two.StockReceive;

/**
 *  股票请求实现类
 *
 * Author: GL
 * Date: 2021-11-05
 */
public class StockClientCommand extends StockCommand {

    public StockClientCommand(StockReceive stockService) {
        super(stockService);
    }

    public void execute(StockType stockType) {
        switch (stockType) {
            case BUY:
                super.getStockService().buy();
                break;
            case SELL:
                super.getStockService().sell();
                break;
            default:
                throw new RuntimeException(" 请求类型异常 ");
        }
    }

}
