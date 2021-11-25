package org.example.design.creative.factory.complete;

/**
 *  此案例是标准工厂模式，用于解决一对多静态简单工厂模式中代码逻辑复杂的问题[simple.factory2]
 *
 *      标准工厂模式是类的创建模式，又叫做虚拟构造子(Virtual Constructor)模式或者多态性工厂（Polymorphic Factory）模式。
 *      标准工厂模式的用意是定义一个创建产品对象的工厂接口，将实际创建工作推迟到子类中。
 *
 *  结构：
 *
 *
 *
 *
 *  总结：
 *      1、标准工厂模式和简单工厂模式在结构上的不同很明显。工厂方法模式的核心是一个抽象工厂类，而简单工厂模式把核心放在一个具体类的静态函数上。
 *      2、标准工厂模式方法模式退化后可以变得很像简单工厂模式。设想如果非常确定一个系统只需要一个具体工厂类，那么不妨把抽象工厂类合并到具体工厂类中去。
 *         由于只有一个具体工厂类，所以不妨将工厂方法改为静态方法，这时候就得到了简单工厂模式。
 *      3、如果系统需要加入一个新的导出类型，那么所需要的就是向系统中加入一个这个导出类以及所对应的工厂类。
 *         没有必要修改客户端，也没有必要修改抽象工厂角色或者其他已有的具体工厂角色。对于增加新的导出类型而言，这个系统完全支持“开-闭原则”。
 *
 *  缺点：标准工厂模式虽然符合开闭原则，但具体工厂了可以使用单例模式代替，这样即不会被创建
 *
 * Author: GL
 * Date: 2021-11-25
 */
public class Test {
    public static void main(String[] args) {
        final UserFactory parentInstance = ParentFactory.INSTANCE;
        final UserFactory childInstance = ChildFactory.INSTANCE;
        System.out.println(parentInstance.create("parent"));
        System.out.println(childInstance.create("child"));
    }
}
