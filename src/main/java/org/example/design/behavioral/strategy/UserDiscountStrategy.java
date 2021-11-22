package org.example.design.behavioral.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *  普通用户折扣策略实体类
 *
 * Author: GL
 * Date: 2021-11-22
 */
public class UserDiscountStrategy extends DiscountStrategy {

    protected UserDiscountStrategy(String discount) {
        super(discount);
    }

    public BigDecimal getDiscount(BigDecimal total) {
        // 普通会员打九折:
        return total.multiply(new BigDecimal(super.getDiscount())).setScale(2, RoundingMode.DOWN);
    }
}