package org.example.design.structural.composite;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *  容器节点(盒子), 可以继续放入商品
 * Author: GL
 * Date: 2021-10-29
 */
public class BoxNode implements Node {
    // 盒子价格
    private final double price;
    private final List<Node> list = new CopyOnWriteArrayList<>();

    public BoxNode(double price, Node... node) {
        this.price = price;
        this.list.addAll(Arrays.asList(node));
    }

    // 返回值语法糖
    @Override
    public Node add(Node node) {
        this.list.add(node);
        return this;
    }

    // 循环调用子节点的totalPrice函数即可, 无需关心子节点的实现
    @Override
    public double totalPrice() {
        double totalPrice = this.price;
        totalPrice += list.stream().mapToDouble(Node::totalPrice).sum();
        return totalPrice;
    }
}
