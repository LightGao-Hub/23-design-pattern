package org.example.design.behavioral.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;


/**
 *  策略模式是一种行为设计模式, 它能让你定义一系列算法, 并将每种算法分别放入独立的类中, 以使算法的对象能够相互替换.
 *
 *  策略模式在Java标准库中应用非常广泛, 我们以排序为例, 看看如何通过Arrays.sort()实现忽略大小写排序：
 *
 *      String[] array = { "apple", "Pear", "Banana", "orange" };
 *      Arrays.sort(array, String::compareToIgnoreCase);
 *
 *  一个完整的策略模式要定义策略以及使用策略的上下文. 我们以购物车结算为例, 假设网站针对普通会员、Prime会员有不同的折扣, 同时活动期间还有一个满100减20的活动, 这些就可以作为策略实现.
 *
 *  由于jdk1.8新增Lambda函数式接口功能，故此模式可以使用jdk1.8内置函数式接口实现策略模式。
 *
 *  结构：
 *        使用策略客户端
 *        ┌─────────┐
 *        │ Context │
 *        └─────────┘
 *             ▲
 *             │
 *    ┌───────────────────────────┐
 *    │DiscountContext            │         策略接口
 *    │ └totalPrice               │       ┌──────────┐
 *    │ └calculatePrice(Strategy) │<------│ Strategy │
 *    └───────────────────────────┘       └──────────┘
 *             ▲                               ▲
 *             │                               │
 *             │               ┌──────────────────────────────────┐
 *   ┌────────────────────┐    │ Function<BigDecimal, BigDecimal> │<---jdk1.8函数式接口
 *   │MallDiscountContext │    │  └R apply(T t)                   │
 *   └────────────────────┘    └──────────────────────────────────┘
 *
 *
 *
 *  总结：
 *      1、策略模式、状态模式、命令模式的设计思想十分相似, 都是将：策略, 状态, 命令. 进行解耦, 单独抽离出来封装成类, 由使用方调用即可
 *      2、策略模式和命令模式的大体设计几乎完全一致, 都是根据命令或策略进行处理, 对于使用方[context/client] 不会缓存任何状态,
 *          区别在于策略模式主要是针对单一的算法进行解耦, 而命令模式则还包括命令的撤回和历史命令记录等;
 *
 * Author: GL
 * Date: 2021-11-22
 */
@Log4j2
public class TestStrategy {
    @Test
    public void test() {
        // 注册商场策略上下文
        DiscountContext ctx = new MallDiscountContext(BigDecimal.valueOf(105));

        // 使用普通会员折扣: 九折
        BigDecimal pay1 = ctx.calculatePrice((totalPrice) ->
                totalPrice.multiply(new BigDecimal("0.9")).setScale(2, RoundingMode.DOWN));
        log.info(pay1);

        // 使用满减折扣: 满100减20
        BigDecimal pay2 = ctx.calculatePrice((totalPrice) ->
                totalPrice.subtract(totalPrice.compareTo(BigDecimal.valueOf(100)) >= 0 ? BigDecimal.valueOf(20) : BigDecimal.ZERO));
        log.info(pay2);

        // 使用Prime会员折扣: 八折
        BigDecimal pay3 = ctx.calculatePrice((totalPrice) ->
                totalPrice.multiply(new BigDecimal("0.8")).setScale(2, RoundingMode.DOWN));
        log.info(pay3);
    }
}
