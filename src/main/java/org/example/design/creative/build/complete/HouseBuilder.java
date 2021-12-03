package org.example.design.creative.build.complete;


/**
 *  房间建造者接口，提供各个属性的接口函数
 *
 * Author: GL
 * Date: 2021-12-03
 */
public abstract class HouseBuilder {
    // 持有House类
    private final House house = new House();

    // 可选参数函数
    public abstract HouseBuilder windows(int windows);
    public abstract HouseBuilder doors(int doors);
    public abstract HouseBuilder rooms(int rooms);
    public abstract HouseBuilder hasGarage(boolean hasGarage);
    public abstract HouseBuilder hasSwimPool(boolean hasSwimPool);
    public abstract HouseBuilder hasGarden(boolean hasGarden);

    // 返回函数
    public House getHouse() {
        return this.house;
    }

}
