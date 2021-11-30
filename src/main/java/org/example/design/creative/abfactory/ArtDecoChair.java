package org.example.design.creative.abfactory;

/**
 *  装饰风椅子
 *
 * Author: GL
 * Date: 2021-11-29
 */
public class ArtDecoChair implements Chair {
    @Override
    public void sit() {
        System.out.println("装饰风椅子...");
    }
}
