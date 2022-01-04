package org.example.design.creative.abfactory;

import lombok.extern.log4j.Log4j2;

/**
 *  维多利亚椅子
 *
 * Author: GL
 * Date: 2021-11-29
 */
@Log4j2
public class VictorianChair implements Chair {
    @Override
    public void sit() {
        log.info("Victoria chair...");
    }
}
