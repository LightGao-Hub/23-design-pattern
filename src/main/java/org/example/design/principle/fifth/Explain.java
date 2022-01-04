package org.example.design.principle.fifth;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 *  迪米特原则, 详细请看：https://app.yinxiang.com/fx/620e788d-f849-4c81-88c6-935e356b9094
 *
 *  迪米特原则有很多种说法, 比如：一个类应该应该对其他类尽可能了解得最少；类只与直接的朋友通信等等. 但是其最终目的只有一个, 就是让类间解耦.
 *
 *  就是说一个对象应该对其他对象保持最少的了解. 正如最少知识原则这个定义一样, 一个类应该对其耦合的其他类或所调用的类知道得最少.
 *  所耦合的类内部无论如何复杂, 怎么实现的我都不需要知道, 我只调用你public出来的这些方法, 其他都不用知道.
 *
 * Author: GL
 * Date: 2021-12-12
 */
public class Explain {
}

// 反面例子
class A {
    public B getB() {
        return new B();
    }

    // 问题在这：A和C又不是好朋友, 为什么在类A中会出现类C呢？他们又互相不认识. 故违反了迪米特原则.
    public void work() {
        B b = getB();
        C c = b.getC("Wang Wu");
        c.work();
    }
}

class B {
    public C getC(String name) {
        return new C(name);
    }
}
@Log4j2
@Data
class C {
    private String name;
    C(String name) {
        this.name = name;
    }
    public void work() {
        log.info(String.format("counter-example: %s have done it well", name));
    }
}

// 正确例子
@Data
class A2 {
    private String name;
    A2(String name) {
        this.name = name;
    }
    public B2 getB(String name) {
        return new B2();
    }
    // 此处遵守迪米特原则, 即A2最少知道B2的work函数, 而无需关联C2
    public void work() {
        B2 b = getB("Li Si");
        b.work();
    }
}

class B2 {
    public C2 getC(String name) {
        return new C2(name);
    }

    public void work() {
        C2 c = getC("Wang Wu");
        c.work();
    }
}
@Log4j2
@Data
class C2 {
    private String name;
    C2(String name) {
        this.name = name;
    }
    public void work() {
        log.info(String.format("positive example: %s have done it well", name));
    }
}

