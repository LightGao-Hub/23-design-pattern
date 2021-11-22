package org.example.design.behavioral.strategy;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * Author: GL
 * Date: 2021-11-22
 */
public abstract class DiscountContext implements Context {
    // 缴费价格
    @Getter
    private final BigDecimal totalPrice;

    public DiscountContext(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    // 根据策略计算价格
    protected abstract BigDecimal calculatePrice(DiscountStrategy discountStrategy);
}
