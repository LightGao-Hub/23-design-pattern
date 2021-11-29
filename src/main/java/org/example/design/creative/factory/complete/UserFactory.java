package org.example.design.creative.factory.complete;

import org.example.design.creative.factory.simple.factory2.Person;

/**
 *  工厂接口
 *
 * Author: GL
 * Date: 2021-11-25
 */
public interface UserFactory {

    Person create(String name);
}
