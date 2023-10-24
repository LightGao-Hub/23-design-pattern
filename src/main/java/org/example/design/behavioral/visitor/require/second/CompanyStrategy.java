package org.example.design.behavioral.visitor.require.second;

/**
 *  公司评绩效策略基类
 *
 * Author: GL
 * Date: 2021-11-23
 */
public abstract class CompanyStrategy implements Strategy {

    // 由子类实现策略
    protected abstract void strategy(Staff staff);
}
