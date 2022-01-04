package org.example.design.structural.bridge;

import lombok.extern.log4j.Log4j2;

/**
 *  奔驰品牌实现类
 * Author: GL
 * Date: 2021-10-28
 */
@Log4j2
public class Benz implements Brand {
    @Override
    public void introduce() {
        log.info(" This is Mercedes Benz ");
    }
}
