package org.example.design.structural.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 *  动态代理日志工厂类
 *  此成员变量一般是Object，也可以是真实业务类的接口，这里之所以设置为UserDao类型是为了对此动态代理类进行限制，即可针对UserDao接口进行动态代理
 */
public class ProxyFactoryLog {

    private final UserDao userdao;// 维护一个目标对象

    public ProxyFactoryLog(UserDao userdao) {
        this.userdao = userdao;
    }

    // 为目标对象生成内存中的代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(userdao.getClass().getClassLoader(), userdao.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("开始执行函数");

                    // 执行目标对象方法, 可以获取返回值，不过此demo没有使用
                    Object returnValue = method.invoke(userdao, args);

                    System.out.println("函数执行结束");
                    return null;
                });
    }
}