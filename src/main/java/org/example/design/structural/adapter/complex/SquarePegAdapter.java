package org.example.design.structural.adapter.complex;

/**
 *  方钉适配到圆孔的适配器
 * Author: GL
 * Date: 2021-10-28
 */
public class SquarePegAdapter extends RoundPeg {
    private final SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        double result;
        // 计算可以适合此钉的最小圆半径。
        result = (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
        return result;
    }
}
