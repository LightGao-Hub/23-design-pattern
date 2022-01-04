package org.example.design.behavioral.visitor.require.second;

import static org.example.design.config.FinalConfig.TEN_SIZE;
import static org.example.design.config.FinalConfig.THOUSAND_SIZE;

import java.util.Random;

/**
 *  工程师
 *
 * Author: GL
 * Date: 2021-11-23
 */
public class EngineerStaff extends Staff {

    public EngineerStaff(String name) {
        super(name, StaffType.ENGINEER);
    }

    // 工程师一年的代码数量
    public int getCodeLines() {
        return new Random().nextInt(TEN_SIZE * THOUSAND_SIZE);
    }
}
