package org.example.design.creative.build.complete;

/**
 *  house的指导类：创建出固定的几个house类
 *  枚举类更安全
 *
 * Author: GL
 * Date: 2021-12-03
 */
public enum HouseDirector { ;
    @SuppressWarnings("checkstyle:magicnumber")
    public static House makeGarageHouseBuilder() {
        return new GarageHouseBuilder().windows(1)
                .doors(1)
                .rooms(1)
                .hasGarage(true)
                .getHouse();
    }
    @SuppressWarnings("checkstyle:magicnumber")
    public static House makeSwimPoolHouseBuilder() {
        return new SwimPoolHouseBuilder().windows(2)
                .doors(2)
                .rooms(2)
                .hasSwimPool(true)
                .getHouse();
    }
    @SuppressWarnings("checkstyle:magicnumber")
    public static House makeGardenHouseBuilder() {
        return new GardenHouseBuilder().windows(3)
                .doors(3)
                .rooms(3)
                .hasGarden(true)
                .getHouse();
    }
    @SuppressWarnings("checkstyle:magicnumber")
    public static House makeGardenSwimPoolHouseBuilder() {
        return new GardenSwimPoolHouseBuilder().windows(4)
                .doors(4)
                .rooms(4)
                .hasGarden(true)
                .hasSwimPool(true)
                .getHouse();
    }
}
