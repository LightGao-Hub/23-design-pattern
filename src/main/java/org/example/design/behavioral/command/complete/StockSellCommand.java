package org.example.design.behavioral.command.complete;

import lombok.extern.log4j.Log4j2;
import org.example.design.behavioral.command.require.first.StockReceive;

/**
 *  股票抛售命令实现类
 *
 * Author: GL
 * Date: 2021-11-05
 */
@Log4j2
public class StockSellCommand extends StockCommand {

    protected StockSellCommand(StockReceive stockService) {
        super(stockService);
    }

    @Override
    public void execute() {
        super.getStockService().sell();
    }

    @Override
    public void undo() {
        log.info("撤回操作");
        super.getStockService().buy();
    }

    @Override
    public String toString() {
        return "StockSellCommand{}";
    }
}
