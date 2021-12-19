package org.example.design.behavioral.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *  prime用户折扣策略实现类
 *
 * Author: GL
 * Date: 2021-11-22
 */
public class PrimeUserDiscountStrategy extends DiscountStrategy {


    public PrimeUserDiscountStrategy(String discount) {
        super(discount);
    }

    public BigDecimal getDiscount(BigDecimal total) {
        // prime会员打八折:
        return total.multiply(new BigDecimal(super.getDiscount())).setScale(2, RoundingMode.DOWN);
    }
}