package org.example.design.behavioral.strategy;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 *  策略接口
 *
 * Author: GL
 * Date: 2021-11-22
 */
public interface Strategy extends Function<BigDecimal, BigDecimal> {
}
