package org.example.design.behavioral.visitor.simple.one;

/**
 *  此案例用来实现java: 两个单项分派[多态] + 静态分派[重载]
 *
 * Author: GL
 * Date: 2021-11-22
 */
public class Test {
    public static void main(String[] args) {
        //组合1
        East east = new SubEast1();
        West west = new SubWest1();
        east.goEast(west);
        //组合2
        east = new SubEast2();
        west = new SubWest2();
        east.goEast(west);
    }
}
