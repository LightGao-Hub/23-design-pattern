package org.example.design.creative.build.complete;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * Author: GL
 * Date: 2021-12-02
 */
@Data
@Log4j2
public class House {

    private int windows;
    private int doors;
    private int rooms;
    private boolean hasGarage;
    private boolean hasSwimPool;
    private boolean hasGarden;

    // 方便测试
    public void print() {
        log.info(this);
    }

}
