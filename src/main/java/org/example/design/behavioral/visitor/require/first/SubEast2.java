package org.example.design.behavioral.visitor.require.first;

/**
 * Author: GL
 * Date: 2021-11-22
 */
public class SubEast2 extends East {
    @Override
    public void goEast(West west) {
        west.goWest(this);
    }

    public String myName2() {
        return "SubEast2";
    }
}
