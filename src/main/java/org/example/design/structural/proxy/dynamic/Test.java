package org.example.design.structural.proxy.dynamic;

/**
 * Author: GL
 * Date: 2021-10-09
 *
 * 理解：
 *  动态代理模式可以理解为是为每一个真实业务类而动态的在JVM内存中创建一个独立的代理类(静态代理类则是真实创建一个类，并且有class文件)，这里统一使用的ProxyFactory来进行在内存中创建代理类！
 *  但是要注意，动态代理其目的是为了增强之前真实业务的函数，比如函数执行前后打印日志或开关事务，那么在ProxyFactory里面的getProxyInstance方法中最后有一个处理函数，此处理函数里面可以写增强的代码比如增加日志或者事务等等，
 *  但是最终要有的method.invoke，因为这是真是业务类的函数要调用！
 *  不过此函数写完之后，就代表增强函数的代码就固定死了，比如在getProxyInstance方法中只写了执行函数前后打印日志的增强代码，那以后只要是经过这个动态代理类生成的实例调用函数就只会打印两个日志的增强
 *  那也就是说一个动态代理类：ProxyFactory只适用于一组业务，比如开启事务的动态代理类就都可以用ProxyFactoryAffair类！
 *  但是我要是想来一个函数执行前先打印个日志，函数执行结束后再打印个日志呢？那就得再新建一个关于打印日志增强函数的动态代理类：ProxyFactoryLog
 *
 *  总结：动态代理类适用于一组相同业务！用于增强原有业务函数！！
 */
public class Test {

    public static void main(String[] args) {
        testProxyFactoryAffair();
        System.out.println("-----------------------------------");
        testProxyFactoryLog();
    }

    public static void testProxyFactoryAffair() {
        UserDao dao = new UserDaoImpl();
        UserDao proxy = (UserDao) new ProxyFactoryAffair(dao).getProxyInstance();
        //执行代理方法
        proxy.save("hello world");
        proxy.update();
    }

    public static void testProxyFactoryLog() {
        UserDao dao = new UserDaoImpl();
        UserDao proxy = (UserDao) new ProxyFactoryLog(dao).getProxyInstance();
        //执行代理方法
        proxy.save("hello world");
        proxy.update();
    }
}
