package org.example.design.creative.abfactory;

/**
 *  装饰风艺术工厂：采用枚举单例更安全
 *
 * Author: GL
 * Date: 2021-11-29
 */
public enum ArtDecoFactory implements AbstractFactory {

    INSTANCE;

    @Override
    public Chair createChair() {
        return new ArtDecoChair();
    }

    @Override
    public Sofa createSofa() {
        return new ArtDecoSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ArtDecoCoffeeTable();
    }
}
