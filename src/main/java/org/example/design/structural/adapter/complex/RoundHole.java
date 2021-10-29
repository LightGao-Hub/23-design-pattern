package org.example.design.structural.adapter.complex;

/**
 *  圆孔类
 * Author: GL
 * Date: 2021-10-28
 */
public class RoundHole {
    // 半径
    private final double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public boolean fits(RoundPeg peg) {
        boolean result;
        result = (this.getRadius() >= peg.getRadius());
        return result;
    }
}
