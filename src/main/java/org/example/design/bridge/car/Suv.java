package org.example.design.bridge.car;

import org.example.design.bridge.brand.Brand;
import org.example.design.bridge.engine.Engine;

/**
 *  越野车实现类
 * Author: GL
 * Date: 2021-10-28
 */
public class Suv extends Car {

    public Suv(Engine engine, Brand brand) {
        super(engine, brand);
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println(" SUV出发了 ");
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println(" 花了我40W ");
    }
}
