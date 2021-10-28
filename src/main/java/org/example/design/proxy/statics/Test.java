package org.example.design.proxy.statics;

/**
 *  理解：静态代理模式中，代理类和真实业务类必须实现同一个接口，动态代理由于是反射机制可以不用限制，但建议根据业务进行限制，详情看dynamic包代码注释
 * Author: GL
 * Date: 2021-10-28
 */
public class Test {
    public static void main(String[] args) {
        final UserDaoImpl userDao = new UserDaoImpl();
        final UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);
        userDaoProxy.save("hello world");
        userDaoProxy.update();
    }
}
