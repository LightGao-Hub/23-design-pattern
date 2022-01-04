package org.example.design.structural.bridge;

import lombok.extern.log4j.Log4j2;

/**
 *  跑车实现类
 * Author: GL
 * Date: 2021-10-28
 */
@Log4j2
public class SportsCar extends Car {

    public SportsCar(Engine engine, Brand brand) {
        super(engine, brand);
    }

    @Override
    public void drive() {
        super.drive();
        log.info(" The sports car is leaving ");
    }

    @Override
    public void introduce() {
        super.introduce();
        log.info("It cost me 100W");
    }
}
