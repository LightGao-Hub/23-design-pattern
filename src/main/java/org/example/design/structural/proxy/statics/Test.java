package org.example.design.structural.proxy.statics;

/**
 *  代理模式是一种结构型设计模式， 让你能够提供对象的替代品或其占位符。 代理控制着对于原对象的访问， 并允许在将请求提交给对象前后进行一些处理。
 *
 *  代理模式又分为静态代理和动态代理：
 *
 *      在静态代理模式中，代理类和真实业务类必须实现同一个接口，动态代理由于是反射机制可以不用限制，但建议根据业务进行限制，详情看dynamic包代码注释
 *
 *  静态代理结构：看着和装饰器和适配器比较像，实际还是有所不同，详细看代码
 *
 *               ┌─────────────┐
 *               │  UserDao    │ 真实业务接口
 *               └─────────────┘
 *                     ▲
 *        ┌────────────┼─────────────────┐
 *        │                              │
 *  ┌────────────────┐             ┌──────────────┐
 *  │ UserDaoImpl    │ 具体实现类    │ UserDaoProxy │ 代理类
 *  └────────────────┘             └──────────────┘
 *
 * Author: GL
 * Date: 2021-10-28
 */
public class Test {
    // 这里之所以通过静态代码块赋值给userDaoProxy原因是为了让读者更容易理解代理模式和装饰器模式的区别
    // 在代理模式中，用户拿到的就是一个代理类userDaoProxy，对于里面的UserDao的实现类是完全黑盒，也完全不需要知道，只需要使用代理类的增强函数即可
    // 而装饰器模式则不同，装饰器模式是将内部UserDao的实现类给与用户，让用户自己使用增强的装饰器进行嵌套并自我组合使用！
    // 所以装饰器模式下真实业务的生命周期由用户决定，而代理模式中真实业务的生命周期由代理类决定！
    private static final UserDaoProxy userDaoProxy;

    static {
        userDaoProxy = new UserDaoProxy(new UserDaoImpl());
    }

    public static void main(String[] args) {
        userDaoProxy.save("hello world");
        userDaoProxy.update();
    }

}
