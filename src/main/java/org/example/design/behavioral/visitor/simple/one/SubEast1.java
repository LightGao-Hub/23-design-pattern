package org.example.design.behavioral.visitor.simple.one;

/**
 * Author: GL
 * Date: 2021-11-22
 */
public class SubEast1 extends East{
    @Override
    public void goEast(West west) {
        west.goWest(this);
    }

    public String myName1(){
        return "SubEast1";
    }
}
