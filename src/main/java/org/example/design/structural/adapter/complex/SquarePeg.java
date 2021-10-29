package org.example.design.structural.adapter.complex;

/**
 *  方钉类
 * Author: GL
 * Date: 2021-10-28
 */
public class SquarePeg {
    private final double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getSquare() {
        double result;
        result = Math.pow(this.width, 2);
        return result;
    }
}
