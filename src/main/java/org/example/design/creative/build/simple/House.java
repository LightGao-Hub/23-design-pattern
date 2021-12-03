package org.example.design.creative.build.simple;

import lombok.Builder;
import lombok.Data;

/**
 * Author: GL
 * Date: 2021-12-02
 */
@Builder
@Data
public class House {

    private int windows;
    private int doors;
    private int rooms;
    private boolean hasGarage;
    private boolean hasSwimPool;
    private boolean hasGarden;

}
