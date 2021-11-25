package org.example.design.creative.factory.perfect;

import org.example.design.creative.factory.simple.factory2.Parent;

/**
 *  工厂接口
 *
 * Author: GL
 * Date: 2021-11-25
 */
public interface UserFactory {

    Parent create(String name);
}
