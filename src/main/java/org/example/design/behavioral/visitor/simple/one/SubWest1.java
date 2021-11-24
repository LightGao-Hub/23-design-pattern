package org.example.design.behavioral.visitor.simple.one;

/**
 * Author: GL
 * Date: 2021-11-22
 */
public class SubWest1 extends West{

    @Override
    public void goWest(SubEast1 east) {

        System.out.println("SubWest1 + " + east.myName1());
    }

    @Override
    public void goWest(SubEast2 east) {

        System.out.println("SubWest1 + " + east.myName2());
    }
}
