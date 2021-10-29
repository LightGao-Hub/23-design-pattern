package org.example.design.structural.bridge.brand;

/**
 *  奔驰品牌实现类
 * Author: GL
 * Date: 2021-10-28
 */
public class Benz implements Brand {
    @Override
    public void introduce() {
        System.out.println(" 这是奔驰！ ");
    }
}
