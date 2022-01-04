package org.example.design.behavioral.state;

import java.util.Objects;

/**
 *  股票用户客户端
 *
 * Author: GL
 * Date: 2021-11-19
 */
public class StockUserClient extends StockClient {

    protected StockUserClient(StockState stockState) {
        super(stockState);
    }

    @Override
    public void send() {
        Objects.requireNonNull(super.getStockState(), "Status cannot be empty");
        super.getStockState().handle();
    }
}
