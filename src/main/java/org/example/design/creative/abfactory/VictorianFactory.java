package org.example.design.creative.abfactory;

/**
 *  维多利亚工厂：采用枚举单例更安全
 *
 * Author: GL
 * Date: 2021-11-29
 */
public enum  VictorianFactory implements AbstractFactory {

    INSTANCE;

    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }
}
