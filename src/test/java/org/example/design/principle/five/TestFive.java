package org.example.design.principle.five;

import org.junit.Test;

/**
 * Author: GL
 * Date: 2021-12-13
 */
public class TestFive {
    @Test
    public void test() {
        wrong();
        right();
    }

    /**
     * 看过a.work()函数代码逻辑后，相信很多人都会明白，这种场景在实际开发中是非常常见的一种情况。对象A需要调用对象B的方法，对象B有需要调用对象C的方法……就是常见的getXXX().getXXX().getXXX()
     * ……类似于这种代码。问题就出在这里：A和C又不是好朋友，为什么在类A中会出现类C呢？他们又互相不认识。故违反了迪米特法则。
     * 如果你发现你的代码中也有这样的代码，那就考虑下是不是违反迪米特法则，是不是要重构一下了。
     */
    private void wrong() {
        A a = new A("张三");
        a.work();
    }

    private void right() {
        A2 a = new A2("张三");
        a.work();
    }
}
