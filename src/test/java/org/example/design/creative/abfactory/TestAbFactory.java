package org.example.design.creative.abfactory;

import org.example.design.creative.abfactory.AbstractFactory;
import org.example.design.creative.abfactory.FactoryType;
import org.junit.Test;

/**
 *  抽象工厂模式是一种创建型设计模式, 它能创建一系列相关的对象, 而无需指定其具体类.
 *
 *  标准工厂方法模式：
 *      是为了解决创建某个抽象产品, 此抽象产品下又分为多个不同子产品的情况, 如图[picture/factory/factory1.jpg], 其中chair就是抽象产品, 不同风格的chair即为子产品
 *      在标准工厂方法模式中, 会设计一个ChairFactory工厂, 再由三个不同风格的chairFactory子类来创建多个不同风格的chair;
 *      缺点也很明显, 就是此工厂为单一产品工厂, 假如有多个产品形成组合产品时, 则缺乏产品之间的依赖性, 如图[picture/factory/factory2.jpg]
 *      图片中横向即为一系列组合产品, 此时我们要解决的是如何让组合产品形成约束.
 *
 *  抽象工厂模式[标准工厂方法的升级版]：
 *      是为了解决一系列产品组成的产品族问题, 如图[picture/factory/factory2.jpg], 图片中分为了装饰风组合产品, 维多利亚组合产品, 现代工厂组合产品
 *      体现在抽象工厂模式下则是横向：装饰风工厂/维多利亚工厂/现代工厂  每个工厂内分别创建各自的产品[chair, sofa, coffee-table]
 *
 *  结构：
 *                          抽象工厂类
 *                ┌─────────────────────────────────┐
 *                │AbstractFactory                  │
 *                │ └Chair createChair()            │─────────────────────────────────────────────────────────────────────────────┐
 *                │ └Sofa createSofa()              │─────────────────────────────────────────────────────────┐                   │
 *                │ └CoffeeTable createCoffeeTable()│───────────────────────────────┐                         │                   │
 *                │ └createFactory(FactoryType)     │                               ▽                        ▽                   ▽
 *                └─────────────────────────────────┘                       ┌────────────────┐             ┌───────┐          ┌──────────┐
 *       装饰风艺术工厂               ▲            维多利亚工厂                  │ CoffeeTable    │             │ Sofa  │          │ Chair    │
 *                ┌────────────────┼────────────────┐                       └────────────────┘             └───────┘          └──────────┘
 *   ┌─────────────────────────┐       ┌──────────────────────────┐                  ▲                         ▲                    ▲
 *   │enum ArtDecoFactory      │       │enum VictorianFactory     │                  │                         │                    │
 *   │ └createChair(){}        │       │ └createChair(){}         │     ┌──────────────────────┐       ┌───────────────┐     ┌────────────────┐
 *   │ └createSofa(){}         │       │ └createSofa(){}          │     │ ArtDecoCoffeeTable   │       │ ArtDecoSofa   │     │ ArtDecoChair   │
 *   │ └createCoffeeTable(){}  │       │ └createCoffeeTable(){}   │     │  ...                 │       │  ...          │     │  ...           │
 *   └─────────────────────────┘       └──────────────────────────┘     │ VictorianCoffeeTable │       │ VictorianSofa │     │ VictorianChair │
 *            │                                     │                   └──────────────────────┘       └───────────────┘     └────────────────┘
 *            │                                     │                                ▲                          ▲                    ▲
 *            └─────────────────────────────────────└────────────────────────────────┘──────────────────────────┘────────────────────┘
 *
 *
 *
 *  总结：
 *      1、应用场景：当系统的产品可以形成一个的产品族[横向依赖]时, 应该使用抽象工厂模式, 若各个子产品业务互不关联则使用标准工厂方法模式即可
 *
 *      2、新增产品构成新产品族时扩展问题：
 *          2.1、第一种：通过AbstractFactory接口增加新产品创建函数
 *          2.2、第二种：创建新产品族抽象接口工厂, 重新构建产品族, 不影响上一个产品族的抽象工厂
 *
 *      3、传参：关于是否传参看业务, 此案例没有开放用户设置实体变量, 而是采用黑盒创建
 *
 *      4、此设计除了createFactory(){}函数实现外, 基本符合开闭原则
 *
 *
 * Author: GL
 * Date: 2021-11-29
 */
public class TestAbFactory {
    @Test
    public void test() {
        final AbstractFactory artFactory = AbstractFactory.createFactory(FactoryType.ART_DECO);
        final AbstractFactory victorianFactory = AbstractFactory.createFactory(FactoryType.VICTORIAN);
        // 构建两种类型
        build(artFactory);
        build(victorianFactory);
    }

    public static void build(AbstractFactory factory) {
        factory.createChair().sit();
        factory.createSofa().lie();
        factory.createCoffeeTable().set();
    }
}
