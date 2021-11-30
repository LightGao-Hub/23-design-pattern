package org.example.design.creative.abfactory;

/**
 *  装饰风咖啡桌
 *
 * Author: GL
 * Date: 2021-11-29
 */
public class ArtDecoCoffeeTable implements CoffeeTable {
    @Override
    public void set() {
        System.out.println("装饰风咖啡桌...");
    }
}
