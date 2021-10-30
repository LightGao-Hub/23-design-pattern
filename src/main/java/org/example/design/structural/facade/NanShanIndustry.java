package org.example.design.structural.facade;

/**
 *  南山工商类，根据企业名称创建公司的工商ID
 *
 * Author: GL
 * Date: 2021-10-30
 */
public class NanShanIndustry implements Industry {
    @Override
    public String register(String name) {
        return String.valueOf(name.hashCode() & Integer.MAX_VALUE);
    }
}
