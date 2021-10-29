package org.example.design.structural.composite;

/**
 *  叶节点(商品节点)，无子节点
 * Author: GL
 * Date: 2021-10-29
 */
public class GoodsNode implements Node {
    // 商品价格
    private final double price;
    private final String name;

    public GoodsNode(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // 不支持存储子节点
    @Override
    public Node add(Node node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double totalPrice() {
        return this.price;
    }
}
