package org.example.design.behavioral.command.complete;

import lombok.extern.log4j.Log4j2;
import org.example.design.behavioral.command.require.first.StockReceive;

/**
 *  股票购买命令实现类
 *
 * Author: GL
 * Date: 2021-11-05
 */
@Log4j2
public class StockBuyCommand extends StockCommand {

    protected StockBuyCommand(StockReceive stockService) {
        super(stockService);
    }

    @Override
    public void execute() {
        super.getStockService().buy();
    }

    @Override
    public void undo() {
        log.info("撤回操作");
        super.getStockService().sell();
    }

    @Override
    public String toString() {
        return "StockBuyCommand{}";
    }
}
