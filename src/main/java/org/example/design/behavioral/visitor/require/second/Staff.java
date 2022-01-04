package org.example.design.behavioral.visitor.require.second;

import static org.example.design.config.FinalConfig.TEN_SIZE;

import java.util.Random;

import lombok.Getter;
import lombok.NonNull;


/**
 *  员工基类, 枚举状态是核心
 *
 * Author: GL
 * Date: 2021-11-23
 */
public abstract class Staff {
    @Getter
    private final StaffType staffType;
    @Getter
    private final String name;
    @Getter
    private final int kpi; // 员工KPI

    public Staff(@NonNull String name, @NonNull StaffType staffType) {
        this.name = name;
        kpi = new Random().nextInt(TEN_SIZE);
        this.staffType = staffType;
    }
}
