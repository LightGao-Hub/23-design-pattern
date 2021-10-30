package org.example.design.structural.facade;

/**
 *  对外提供唯一注册公司的外观类接口
 *
 * Author: GL
 * Date: 2021-10-30
 */
public interface Facade {
    public Company registerCompany(String companyName);
}
