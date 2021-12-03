package org.example.design.creative.build.simple;

/**
 *  此案例为简化版建造者模式，采用@Builder的实现方式
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
public class Test {

    public static void main(String[] args) {
        build1();
        build2();
    }

    // 常用写法
    public static void build1() {
        final House build = House.builder()
                .windows(5)
                .doors(3)
                .rooms(5)
                .hasGarage(true)
                .hasSwimPool(true)
                .build();
        System.out.println(build);
    }

    // 实现原理
    public static void build2() {
        final HouseDemo build = HouseDemo.builder()
                .windows(5)
                .doors(3)
                .rooms(5)
                .hasGarage(true)
                .hasSwimPool(true)
                .build();
        System.out.println(build);
    }
}
