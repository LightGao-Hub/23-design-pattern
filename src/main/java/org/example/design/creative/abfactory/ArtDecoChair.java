package org.example.design.creative.abfactory;

import lombok.extern.log4j.Log4j2;

/**
 *  装饰风椅子
 *
 * Author: GL
 * Date: 2021-11-29
 */
@Log4j2
public class ArtDecoChair implements Chair {
    @Override
    public void sit() {
        log.info("Decorative wind chair...");
    }
}
