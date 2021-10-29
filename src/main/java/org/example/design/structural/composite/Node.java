package org.example.design.structural.composite;

/**
 *  节点抽象
 * Author: GL
 * Date: 2021-10-29
 */
public interface Node {
    // 添加一个节点为子节点:
    Node add(Node node);
    // 总价格：
    double totalPrice();
}
