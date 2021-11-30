package org.example.design.creative.abfactory;

import java.util.Objects;

/**
 *  抽象工厂接口
 *
 * Author: GL
 * Date: 2021-11-29
 */
public interface AbstractFactory {
    Chair createChair();
    Sofa createSofa();
    CoffeeTable createCoffeeTable();

    // 创建子工厂
    static AbstractFactory createFactory(FactoryType factoryType) {
        Objects.requireNonNull(factoryType);
        switch (factoryType) {
            case ART_DECO:
                return ArtDecoFactory.INSTANCE;
            case VICTORIAN:
                return VictorianFactory.INSTANCE;
            default:
                throw new RuntimeException("工厂类型异常");
        }
    }
}
