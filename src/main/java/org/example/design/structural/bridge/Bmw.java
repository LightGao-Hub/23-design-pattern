package org.example.design.structural.bridge;

import lombok.extern.log4j.Log4j2;

/**
 *  奔驰品牌类
 * Author: GL
 * Date: 2021-10-28
 */
@Log4j2
public class Bmw implements Brand {
    @Override
    public void introduce() {
        log.info(" This is BMW ");
    }
}
