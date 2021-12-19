package org.example.design.behavioral.strategy;

import java.math.BigDecimal;

/**
 *  满减策略实现类
 *
 * Author: GL
 * Date: 2021-11-22
 */
public class OverDiscountStrategy extends DiscountStrategy {

    public OverDiscountStrategy(String discount) {
        super(discount);
    }

    public BigDecimal getDiscount(BigDecimal total) {
        // 满100减20优惠:
        return total.subtract(total.compareTo(BigDecimal.valueOf(100)) >= 0 ? BigDecimal.valueOf(20) : BigDecimal.ZERO);
    }
}

