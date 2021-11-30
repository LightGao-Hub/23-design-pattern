package org.example.design.creative.abfactory;

/**
 *  抽象工厂模式是一种创建型设计模式， 它能创建一系列相关的对象， 而无需指定其具体类。
 *
 *  标准工厂模式：
 *      是为了解决创建某个抽象产品，此抽象产品下又分为多个不同子产品的情况，如图[picture/factory/factory1.jpg]，其中chair就是抽象产品，不同风格的chair即为子产品
 *      在标准工厂模式中，会设计一个ChairFactory工厂，再由三个不同风格的chairFactory子类来创建多个不同风格的chair;
 *      缺点也很明显，就是此工厂为单一产品工厂，假如有多个产品形成组合产品时，则缺乏产品之间的依赖性，如图[picture/factory/factory2.jpg]
 *
 *  抽象工厂模式[标准工厂的升级版]：
 *      是为了解决一系列产品组成的产品组合问题，如图[picture/factory/factory2.jpg], 分为了装饰风组合产品，维多利亚组合产品，现代工厂组合产品
 *      体现在抽象工厂模式下则是横向：装饰风工厂/维多利亚工厂/现代工厂  每个工厂内分别创建各自的产品[chair, sofa, coffee-table]
 *
 *  结构：
 *
 *                ┌─────────────────────────────────┐
 *                │AbstractFactory                  │
 *                │ └Chair createChair()            │─────────────────────────────────────────────────────────────────────────────┐
 *                │ └Sofa createSofa()              │─────────────────────────────────────────────────────────┐                   │
 *                │ └CoffeeTable createCoffeeTable()│───────────────────────────────┐                         │                   │
 *                │ └createFactory(FactoryType)     │                               ▽                        ▽                   ▽
 *                └─────────────────────────────────┘                       ┌────────────────┐             ┌───────┐          ┌──────────┐
 *                                 ▲                                        │ CoffeeTable    │             │ Sofa  │          │ Chair    │
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
 *      1、应用场景：当系统的产品可以形成一个的产品组合[横向依赖]时，应该使用抽象工厂模式，若各个子产品业务互不关联则使用标准工厂模式即可
 *
 *      2、新增产品构成新产品组合时扩展问题：
 *          2.1、第一种：通过AbstractFactory接口增加新产品创建函数
 *          2.2、第二种：创建新产品组合抽象接口工厂，重新构建产品组合，不影响上一个抽象工厂
 *
 * Author: GL
 * Date: 2021-11-29
 */
public class Test {
    public static void main(String[] args) {
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
