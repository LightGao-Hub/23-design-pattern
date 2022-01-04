package org.example.design.creative.abfactory;

import lombok.extern.log4j.Log4j2;

/**
 *  装饰风咖啡桌
 *
 * Author: GL
 * Date: 2021-11-29
 */
@Log4j2
public class ArtDecoCoffeeTable implements CoffeeTable {
    @Override
    public void set() {
        log.info("Decorative coffee table...");
    }
}
