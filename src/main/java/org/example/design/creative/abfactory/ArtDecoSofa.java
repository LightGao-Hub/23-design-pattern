package org.example.design.creative.abfactory;

/**
 *  装饰风沙发
 *
 * Author: GL
 * Date: 2021-11-29
 */
public class ArtDecoSofa implements Sofa {
    @Override
    public void lie() {
        System.out.println("装饰风沙发...");
    }
}
