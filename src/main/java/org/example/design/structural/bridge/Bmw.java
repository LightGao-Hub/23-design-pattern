package org.example.design.structural.bridge;

/**
 *  奔驰品牌类
 * Author: GL
 * Date: 2021-10-28
 */
public class Bmw implements Brand {
    @Override
    public void introduce() {
        System.out.println(" 这是宝马！ ");
    }
}
