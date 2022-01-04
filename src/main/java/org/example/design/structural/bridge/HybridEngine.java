package org.example.design.structural.bridge;

import lombok.extern.log4j.Log4j2;

/**
 *  混合动力引擎
 * Author: GL
 * Date: 2021-10-28
 */
@Log4j2
public class HybridEngine implements Engine {
    public void start() {
        log.info(" Start the hybrid engine...");
    }
}
