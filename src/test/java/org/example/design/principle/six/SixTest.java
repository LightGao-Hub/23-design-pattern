package org.example.design.principle.six;

import org.junit.Test;

/**
 * Author: GL
 * Date: 2021-12-14
 */
public class SixTest {
    @Test
    public void test() {
        People jim = new Jim();
        Fruit apple = new Apple();
        Fruit Banana = new Banana();
        jim.eat(apple);
        jim.eat(Banana);
    }
}
