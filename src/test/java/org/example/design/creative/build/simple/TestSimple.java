package org.example.design.creative.build.simple;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

/**
 *  此案例为简化版建造者模式, 实现了@Builder的实现方式
 *
 *  结构：
 *      ┌────────────────────────────────────────────────┐
 *      │HouseDemo                                       │
 *      │ └属性                                           │
 *      │ └static HouseDemo.HouseDemoBuilder builder()   │
 *      │   ┌──────────────────────────────┐             │
 *      │   │static class HouseDemoBuilder │             │
 *      │   │ └属性函数                      │             │
 *      │   │ └HouseDemo build(){}         │             │
 *      │   └──────────────────────────────┘             │
 *      └────────────────────────────────────────────────┘
 *
 *  总结：通过静态内部类实现了@Builder注解功能
 *
 * Author: GL
 * Date: 2021-12-02
 */
@Log4j2
public class TestSimple {

    @Test
    public void test() {
        buildFirst();
        buildSecond();
    }

    // 常用写法
    public static void buildFirst() {
        final House build = House.builder()
                .windows(5)
                .doors(3)
                .rooms(5)
                .hasGarage(true)
                .hasSwimPool(true)
                .build();
        log.info(build);
    }

    // 实现原理
    public static void buildSecond() {
        final HouseDemo build = HouseDemo.builder()
                .windows(5)
                .doors(3)
                .rooms(5)
                .hasGarage(true)
                .hasSwimPool(true)
                .build();
        log.info(build);
    }
}
