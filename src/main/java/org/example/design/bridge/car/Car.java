package org.example.design.bridge.car;

import org.example.design.bridge.Vehicle;
import org.example.design.bridge.brand.Brand;
import org.example.design.bridge.engine.Engine;

/**
 * Author: GL
 * Date: 2021-10-28
 */
public abstract class Car implements Vehicle {
    // 连接Engine和Brand的桥梁 :
    private final Engine engine;
    private final Brand brand;

    public Car(Engine engine, Brand brand) {
        this.engine = engine;
        this.brand = brand;
    }

    public void drive() {   // 驾驶
        engine.start();
    }

    public void introduce() {   // 介绍
        brand.introduce();
    }
}

