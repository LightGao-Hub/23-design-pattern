package org.example.design.structural.bridge;

import lombok.extern.log4j.Log4j2;

/**
 *  汽油引擎
 * Author: GL
 * Date: 2021-10-28
 */
@Log4j2
public class OilEngine implements Engine {
    @Override
    public void start() {
        log.info(" Start the gasoline engine... ");
    }
}
