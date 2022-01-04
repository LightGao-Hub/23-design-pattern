package org.example.design.principle.third;

import org.junit.Test;

/**
 * Author: GL
 * Date: 2021-12-08
 */
public class TestThird {
    @Test
    public void test() {
        wrong();
        right();
    }

    private void wrong() {
        Jim jim = new Jim();
        Apple apple = new Apple();
        jim.eat(apple);
    }

    private void right() {
        People jim = new Jim2();
        Fruit apple = new Apple2();
        Fruit Banana = new Banana();// 这里同时符合了里氏替换原则
        jim.eat(apple);
        jim.eat(Banana);
    }
}
