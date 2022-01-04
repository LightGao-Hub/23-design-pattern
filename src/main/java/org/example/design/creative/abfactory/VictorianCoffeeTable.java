package org.example.design.creative.abfactory;

import lombok.extern.log4j.Log4j2;

/**
 *  维多利亚咖啡桌
 *
 * Author: GL
 * Date: 2021-11-29
 */
@Log4j2
public class VictorianCoffeeTable implements CoffeeTable {

    @Override
    public void set() {
        log.info("Victoria coffee table...");
    }
}
