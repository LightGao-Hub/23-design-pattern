package org.example.design.structural.composite;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

/**
 *  组合模式是一种结构型设计模式, 你可以使用它将对象组合成树状结构, 并且能像使用独立对象一样使用它们
 *
 *      如图：项目/picture/composite/introduce.png
 *      组合模式常见的结构是一个抽象的节点接口, 往下分为容器节点和叶子节点, 容器节点可以继续存放叶子节点或容器节点, 而叶子节点则不可存储其他节点！
 *      注意：只有当应用的核心模型能用树状结构表示, 使用组合模式才有价值.
 *
 *  文件系统举例：从根节点开始:/ 下面有目录[容器节点]或文件[叶节点], 容器节点里面可能还有目录[容器节点]或者文件[子节点], 这样组成了一个树结构！
 *
 *  我们来看一个具体的例子：
 *
 *      你有两类对象：产品和盒子. 一个盒子中可以包含多个产品或者几个较小的盒子. 这些小盒子中同样可以包含一些产品或更小的盒子, 以此类推.
 *
 *      如图： 项目/picture/composite/box.png
 *
 *      假设你希望在这些类的基础上开发一个定购系统. 订单中可以包含无包装的简单产品, 也可以包含装满产品的盒子……以及其他盒子. 此时你会如何计算每张订单的总价格呢？
 *
 *      你可以尝试直接计算：打开所有盒子, 找到每件产品, 然后计算总价. 这在真实世界中或许可行, 但在程序中, 你并不能简单地使用循环语句来完成该工作.
 *      你必须事先知道所有产品和盒子的类别, 所有盒子的嵌套层数以及其他繁杂的细节信息. 因此, 直接计算极不方便, 甚至完全不可行.
 *
 *      组合模式建议使用一个通用接口[节点]来与产品[叶子节点]和盒子[容器节点]进行交互, 并且在该接口中声明一个计算总价的方法.
 *      那么方法该如何设计呢？对于一个产品, 该方法直接返回其价格；对于一个盒子, 该方法遍历盒子中的所有项目, 询问每个项目的价格, 然后返回该盒子的总价格. 如果其中某个项目是小一号的盒子, 那么当前盒子也会遍历其中的所有项目,
 *      以此类推, 直到计算出所有内部组成部分的价格. 你甚至可以在盒子的最终价格中增加额外费用, 作为该盒子的包装费用.
 *
 *      如图：项目/picture/composite/solve.png
 *
 *      该模式的最大优点在于你无需了解构成树状结构的对象的具体类. 你也无需了解对象是简单的产品还是复杂的盒子. 你只需调用通用接口以相同的方式对其进行处理即可. 当你调用该方法后, 对象会将请求沿着树结构传递下去.
 *
 *      结构：                    节点接口
 *                      ┌────────────────────────┐
 *                      │ Node                   │
 *                      │ └Node add(Node node);  │
 *                      │ └totalPrice();         │
 *                      └────────────────────────┘
 *                                  ▲
 *              ┌───────────────────┼─────────────────────┐
 *              │  容器节点                                │ 叶子节点
 *        ┌────────────────────────┐             ┌─────────────────┐
 *        │BoxNode                 │             │ BoxNode         │
 *        │ └list[Node]            │             │ └totalPrice(){};│
 *        │ └Node add(Node node){};│             └─────────────────┘
 *        │ └totalPrice(){};       │
 *        └────────────────────────┘
 *
 *     具体实现如下：
 *
 *          1、确保应用的核心模型能够以树状结构表示. 尝试将其分解为简单元素[商品]和容器[盒子]. 注意, 容器必须能够同时包含简单元素和其他容器.
 *          2、声明节点接口及其一系列方法, 这些方法对简单元素[商品]和容器[盒子]都有意义.
 *
 * Author: GL
 * Date: 2021-10-29
 */
@Log4j2
public class TestComposite {
    @Test
    public void test() {
        final GoodsNode mp3 = new GoodsNode("mp3", 100.00);
        final BoxNode mp3Box = new BoxNode(1.00, mp3);

        final GoodsNode mp4 = new GoodsNode("mp4", 200.00);
        final BoxNode mp4Box = new BoxNode(1.00, mp4);

        final BoxNode mpBox = new BoxNode(2.00, mp3Box, mp4Box);

        final GoodsNode node3 = new GoodsNode("Millet node3", 3000.00);
        final GoodsNode node4 = new GoodsNode("Millet node4", 4000.00);

        final BoxNode phoneBox = new BoxNode(5.00, node3, node4);

        final GoodsNode mac = new GoodsNode("Apple has no box", 9000.00);
        final GoodsNode watch = new GoodsNode("Apple phones don't have boxes", 2000.00);

        // 可以通过语法糖传参
        final Node totalNode = new BoxNode(9.00, mpBox, phoneBox);
        // 也可以通过add语法糖传参
        totalNode.add(mac).add(watch);

        // 计算总价格, 这就是组合模式的好处, 父节点无需关心子节点的价格计算方式！
        log.info(String.format("The total price is：%s", totalNode.totalPrice()));
    }

}
