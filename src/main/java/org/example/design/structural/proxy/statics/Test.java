package org.example.design.structural.proxy.statics;

/**
 *  理解：静态代理模式中，代理类和真实业务类必须实现同一个接口，动态代理由于是反射机制可以不用限制，但建议根据业务进行限制，详情看dynamic包代码注释
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
