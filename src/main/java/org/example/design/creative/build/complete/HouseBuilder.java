package org.example.design.creative.build.complete;


/**
 *  房间建造者接口, 提供各个属性的接口函数
 *
 * Author: GL
 * Date: 2021-12-03
 */
public abstract class HouseBuilder {
    // 持有House类
    private final House house = new House();

    // 可选参数函数
    protected abstract HouseBuilder windows(int windows);
    protected abstract HouseBuilder doors(int doors);
    protected abstract HouseBuilder rooms(int rooms);
    protected abstract HouseBuilder hasGarage(boolean hasGarage);
    protected abstract HouseBuilder hasSwimPool(boolean hasSwimPool);
    protected abstract HouseBuilder hasGarden(boolean hasGarden);

    // 返回函数
    public House getHouse() {
        return this.house;
    }

}
