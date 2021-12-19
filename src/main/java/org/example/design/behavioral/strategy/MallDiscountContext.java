package org.example.design.behavioral.strategy;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *  商场上下文实现类
 *
 * Author: GL
 * Date: 2021-11-22
 */
public class MallDiscountContext extends DiscountContext {

    public MallDiscountContext(BigDecimal totalPrice) {
        super(totalPrice);
    }

    @Override
    protected BigDecimal calculatePrice(DiscountStrategy discountStrategy) {
        Objects.requireNonNull(super.getTotalPrice(), "totalPrice 不允许为空");
        Objects.requireNonNull(discountStrategy, "策略不允许为空");
        return discountStrategy.getDiscount(super.getTotalPrice());
    }
}
