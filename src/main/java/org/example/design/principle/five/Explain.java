package org.example.design.principle.five;

/**
 *  迪米特原则，详细请看：https://app.yinxiang.com/fx/620e788d-f849-4c81-88c6-935e356b9094
 *
 *  迪米特原则有很多种说法，比如：一个类应该应该对其他类尽可能了解得最少；类只与直接的朋友通信等等。但是其最终目的只有一个，就是让类间解耦。
 *
 *  就是说一个对象应该对其他对象保持最少的了解。正如最少知识原则这个定义一样，一个类应该对其耦合的其他类或所调用的类知道得最少。
 *  所耦合的类内部无论如何复杂，怎么实现的我都不需要知道，我只调用你public出来的这些方法，其他都不用知道。
 *
 * Author: GL
 * Date: 2021-12-12
 */
public class Explain {
    public static void main(String[] args) {
        wrong();
        right();
    }

    /**
     * 看过a.work()函数代码逻辑后，相信很多人都会明白，这种场景在实际开发中是非常常见的一种情况。对象A需要调用对象B的方法，对象B有需要调用对象C的方法……就是常见的getXXX().getXXX().getXXX()
     * ……类似于这种代码。问题就出在这里：A和C又不是好朋友，为什么在类A中会出现类C呢？他们又互相不认识。故违反了迪米特法则。
     * 如果你发现你的代码中也有这样的代码，那就考虑下是不是违反迪米特法则，是不是要重构一下了。
     */
    public static void wrong() {
        A a = new A("张三");
        a.work();
    }

    private static void right() {
        A2 a = new A2("张三");
        a.work();
    }
}

// 反面例子
class A {
    public String name;
    public A(String name) {
        this.name = name;
    }
    public B getB(String name) {
        return new B(name);
    }

    // 问题在这：A和C又不是好朋友，为什么在类A中会出现类C呢？他们又互相不认识。故违反了迪米特法则。
    public void work() {
        B b = getB("李四");
        C c = b.getC("王五");
        c.work();
    }
}

class B {
    private String name;
    public B(String name) {
        this.name = name;
    }
    public C getC(String name) {
        return new C(name);
    }
}

class C {
    public String name;
    public C(String name) {
        this.name = name;
    }
    public void work() {
        System.out.println(name + "把这件事做好了: 反例");
    }
}

// 正确例子
class A2 {
    public String name;
    public A2(String name) {
        this.name = name;
    }
    public B2 getB(String name) {
        return new B2(name);
    }
    // 此处遵守迪米特原则，即A2最少知道B2的work函数，而无需关联C2
    public void work() {
        B2 b = getB("李四");
        b.work();
    }
}

class B2 {
    private String name;
    public B2(String name) {
        this.name = name;
    }
    public C2 getC(String name) {
        return new C2(name);
    }

    public void work(){
        C2 c = getC("王五");
        c.work();
    }
}

class C2 {
    public String name;
    public C2(String name) {
        this.name = name;
    }
    public void work() {
        System.out.println(name + "把这件事做好了: 正例");
    }
}

