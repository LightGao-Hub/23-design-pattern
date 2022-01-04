package org.example.design.structural.facade;

/**
 * 枚举单例类
 *  南山工商类, 根据企业名称创建公司的工商ID
 *
 * Author: GL
 * Date: 2021-10-30
 */
public enum NanShanIndustry implements Industry {
    INSTANCE;

    @Override
    public String register(String name) {
        return String.valueOf(name.hashCode() & Integer.MAX_VALUE);
    }
}
