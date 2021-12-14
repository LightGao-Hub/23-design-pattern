package org.example.design.creative.build.complete;

import org.junit.Test;

/**
 *  本案例是传统上建造者模式，实际开发中使用的较少，通常会使用@Builder注解来实现
 *
 *  使用场景：当你需要创建一个可能有许多配置选项属性的对象时, 该模式会特别有用。
 *
 *  此案例的两种实现：
 *      1、只通过建造者实现类进行实现[参考build()函数], 当你不需要生成一些固定参数的模板类时, 单独使用建造者自己构造即可;
 *      2、通过指导者类实现[参考directorBuild()函数], 这里改成了一对一静态简单设计模式, 当你需要生成一些固定参数的house类时使用指导者类创建是合适的;
 *
 *  结构：
 *                                                    建造者抽象父类                              产品实体类                                        指导类
 *                                 ┌────────────────────────────────────────────────┐                               ┌────────────────────────────────────────────────────┐
 *                                 │HouseBuilder                                    │       ┌──────────────┐        │enum HouseDirector                                  │
 *                                 │ └house = new House();                          │<------│House         │        │ └static House makeGarageHouseBuilder(){}           │
 *                                 │ └HouseBuilder windows(int windows);            │       │ └windows     │        │ └static House makeSwimPoolHouseBuilder(){}         │
 *                                 │ └HouseBuilder doors(int doors);                │       │ └doors       │        │ └static House makeGardenHouseBuilder(){}           │
 *                                 │ └HouseBuilder rooms(int rooms);                │       │ └rooms       │        │ └static House makeGardenSwimPoolHouseBuilder(){}   │
 *                                 │ └HouseBuilder hasGarage(boolean hasGarage);    │       │ └hasGarage   │        └────────────────────────────────────────────────────┘
 *                                 │ └HouseBuilder hasSwimPool(boolean hasSwimPool);│       │ └hasSwimPool │
 *                                 │ └HouseBuilder hasGarden(boolean hasGarden);    │       │ └hasGarden   │
 *                                 └────────────────────────────────────────────────┘       └──────────────┘
 *                                                          ▲
 *          ┌───────────────────────────────────────────────┼─────────────────────────────────────────────────────┐
 *   ┌────────────────────┐       ┌───────────────────┐           ┌───────────────────────────┐       ┌─────────────────────┐
 *   │GarageHouseBuilder  │       │GardenHouseBuilder │           │GardenSwimPoolHouseBuilder │       │SwimPoolHouseBuilder │  多个建造者子类
 *   └────────────────────┘       └───────────────────┘           └───────────────────────────┘       └─────────────────────┘
 *
 *  总结：
 *      1、建造者模式一般是针对某个类的属性可选的时候使用
 *      2、此模式只能是 一套建造者父子类族 对应 一个产品类，即一个建造者抽象类无论有多少子类，最终都是针对一个实体！比如现在又来了一个汽车的实体类，有十几个可选配置，此时的HouseBuilder抽象父类就不再适用，需要新建CarBuilder抽象父类！
 *
 * Author: GL
 * Date: 2021-12-02
 */
public class BuildTest {

    @Test
    public void test() {
        build();
        directorBuild();
    }

    // 非指导者构建
    public void build() {
        new GarageHouseBuilder().windows(1)
                .doors(1)
                .rooms(1)
                .hasGarage(true)
                .getHouse()
                .print();

        new SwimPoolHouseBuilder().windows(2)
                .doors(2)
                .rooms(2)
                .hasSwimPool(true)
                .getHouse()
                .print();

        new GardenHouseBuilder().windows(3)
                .doors(3)
                .rooms(3)
                .hasGarden(true)
                .getHouse()
                .print();

        new GardenSwimPoolHouseBuilder().windows(4)
                .doors(4)
                .rooms(4)
                .hasGarden(true)
                .hasSwimPool(true)
                .getHouse()
                .print();
    }

    // 指导者构建
    public void directorBuild() {
        HouseDirector.makeGarageHouseBuilder().print();
        HouseDirector.makeSwimPoolHouseBuilder().print();
        HouseDirector.makeGardenHouseBuilder().print();
        HouseDirector.makeGardenSwimPoolHouseBuilder().print();
    }
}

