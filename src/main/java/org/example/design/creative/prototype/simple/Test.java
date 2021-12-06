package org.example.design.creative.prototype.simple;


/**
 *  此案例通过Object - clone函数实现克隆[此方式最为简单]，需要注意的是被克隆类需要实现Cloneable接口，否则会抛出CloneNotSupportedException异常。
 *
 *  克隆类和原实例并不相等，克隆出的是新的实例
 *
 * Author: GL
 * Date: 2021-12-06
 */
public class Test {
    public static void main(String[] args) {
        final Prototype prototype = new Prototype(1, "prototype");
        final Prototype clone = prototype.clone();
        System.out.println(prototype);
        System.out.println(clone);
        System.out.println(clone == prototype); // 克隆类和原实例并不相等，克隆出的是新的实例
    }
}
