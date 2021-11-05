package org.example.design.behavioral.command.usually.one;


/**
 *  发送放：股票发送放
 *
 * Author: GL
 * Date: 2021-11-05
 */
public abstract class StockClient implements Client {
    // 持有服务端
    private final StockReceive stockService;

    // 请求，此时弊端在于客户端必须对服务端的函数可知，这就增加了后面维护的成本，假如StockReceive新增函数，此类也要进行修改
    protected void buy() {
        stockService.buy();
    }

    protected void sell() {
        stockService.sell();
    }

    public StockClient(StockReceive stockService) {
        this.stockService = stockService;
    }

    public StockReceive getStockService() {
        return this.stockService;
    }
}
