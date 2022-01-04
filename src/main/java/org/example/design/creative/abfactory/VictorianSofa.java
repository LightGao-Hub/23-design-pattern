package org.example.design.creative.abfactory;

import lombok.extern.log4j.Log4j2;

/**
 * Author: GL
 * Date: 2021-11-29
 */
@Log4j2
public class VictorianSofa implements Sofa {
    @Override
    public void lie() {
        log.info("Victoria sofa...");
    }
}
