package org.example.design.structural.proxy.dynamic;

import lombok.extern.log4j.Log4j2;
import org.example.design.structural.proxy.statics.UserDao;
import org.example.design.structural.proxy.statics.UserDaoImpl;
import org.junit.Test;

/**
 * Author: GL
 * Date: 2021-10-09
 *
 * 理解：
 *  动态代理模式可以理解为是为每一个真实业务类而动态的在JVM内存中创建一个独立的代理类(静态代理类则是真实创建一个类, 并且有class文件), 这里统一使用Jdk自带Proxy来实现动态代理
 *  比如此时UserDao又新增多个实现了类，如果是静态代理模式则需要根据每个实现类构建静态代理类，而动态代理只需将UserDao的实现类传递到getProxyInstance函数即可获取到对应代理类！
 *  动态代理其目的也是为了增强之前真实业务的函数, 比如函数执行前后打印日志或开关事务
 *  一个动态代理类ProxyFactoryAffair只适用于一类业务, 比如开启事务业务的动态代理类就都可以用ProxyFactoryAffair类！
 *  但是我要是想来一个函数执行前先打印个日志, 函数执行结束后再打印个日志, 那就需要再新建一个关于打印日志增强函数的动态代理类：ProxyFactoryLog
 *
 *  结构：
 *                        真实业务接口
 *                      ┌─────────────┐
 *                      │  UserDao    │
 *                      └─────────────┘
 *                             ▲
 *        ┌────────────────────┼────────────────────┐
 *        │                                         │
 *  ┌────────────────┐                      ┌───────────────┐
 *  │ UserDaoImpl    │                      │ ProxyFactory  │
 *  └────────────────┘                      └───────────────┘
 *     具体业务类                                     ▲
 *                             ┌────────────────────┼────────────────────┐
 *                             │                                         │
 *                      ┌─────────────────┐                   ┌────────────────────┐
 *                      │ ProxyFactoryLog │                   │ ProxyFactoryAffair │
 *                      └─────────────────┘                   └────────────────────┘
 *                         日志代理类                                   事务代理类
 *
 *  注意：
 *      下面代码中之所以通过静态代码块赋值给proxyAffair/proxyLogDe原因是为了让读者更容易理解代理模式和装饰器模式的区别
 *      在代理模式中, 用户拿到的就是一个代理类proxyAffair/proxyLogDe, 对于里面的UserDao的实现类是完全黑盒, 也完全不需要知道, 只需要使用代理类的增强函数即可
 *      而装饰器模式则不同, 装饰器模式是将内部UserDao的实现类给与用户, 让用户自己使用增强的装饰器进行嵌套并自我组合使用！
 *      所以装饰器模式下真实业务的生命周期由用户决定, 而代理模式中真实业务的生命周期由代理类决定
 *
 *  总结：动态代理类适用于一组相同业务, 用于增强原有业务函数
 */
@Log4j2
public class TestDynamic {

    private static final UserDao proxyAffair;
    private static final UserDao proxyLog;

    static {
        UserDao userDao = new UserDaoImpl();
        proxyAffair = new ProxyFactoryAffair(userDao).getProxyInstance();
        proxyLog = new ProxyFactoryLog(userDao).getProxyInstance();
    }

    @Test
    public void test() {
        testAffair();
        log.info("-----------------------------------");
        testLog();
    }

    public void testAffair() {
        //执行代理方法
        proxyAffair.save("hello dynamic proxy");
        proxyAffair.update();
    }

    public void testLog() {
        //执行代理方法
        proxyLog.save("hello dynamic proxy");
        proxyLog.update();
    }
}
