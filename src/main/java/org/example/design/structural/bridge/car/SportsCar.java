package org.example.design.structural.bridge.car;

import org.example.design.structural.bridge.brand.Brand;
import org.example.design.structural.bridge.engine.Engine;

/**
 *  跑车实现类
 * Author: GL
 * Date: 2021-10-28
 */
public class SportsCar extends Car {

    public SportsCar(Engine engine, Brand brand) {
        super(engine, brand);
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println(" 跑车出发了 ");
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println(" 花了我100W ");
    }
}
