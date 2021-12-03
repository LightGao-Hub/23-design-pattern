package org.example.design.creative.build.complete;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: GL
 * Date: 2021-12-02
 */
@NoArgsConstructor
@Data
public class House {

    private int windows;
    private int doors;
    private int rooms;
    private boolean hasGarage;
    private boolean hasSwimPool;
    private boolean hasGarden;

    // 方便测试
    public void print() {
        System.out.println(this);
    }

}
