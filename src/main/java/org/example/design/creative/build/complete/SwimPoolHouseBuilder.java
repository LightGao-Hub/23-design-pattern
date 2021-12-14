package org.example.design.creative.build.complete;

/**
 *  泳池房子建造者
 *
 * Author: GL
 * Date: 2021-12-03
 */
public class SwimPoolHouseBuilder extends HouseBuilder {

    @Override
    public HouseBuilder windows(int windows) {
        super.getHouse().setWindows(windows);
        return this;
    }

    @Override
    public HouseBuilder doors(int doors) {
        super.getHouse().setDoors(doors);
        return this;
    }

    @Override
    public HouseBuilder rooms(int rooms) {
        super.getHouse().setRooms(rooms);
        return this;
    }

    @Override
    public HouseBuilder hasSwimPool(boolean hasSwimPool) {
        super.getHouse().setHasSwimPool(hasSwimPool);
        return this;
    }

    // 下面两个函数为空
    @Override
    public HouseBuilder hasGarage(boolean hasGarage) {
        return this;
    }

    @Override
    public HouseBuilder hasGarden(boolean hasGarden) {
        return this;
    }

}
