package org.example.design.structural.proxy.dynamic;

import java.lang.reflect.Proxy;

import lombok.extern.log4j.Log4j2;
import org.example.design.structural.proxy.statics.UserDao;

/**
 *  动态代理日志工厂类
 *  此成员变量一般是Object, 也可以是真实业务类的接口, 这里之所以设置为UserDao类型是为了对此动态代理类进行限制, 即可针对UserDao接口进行动态代理
 */
@Log4j2
public class ProxyFactoryLog extends ProxyFactory<UserDao> {

    public ProxyFactoryLog(UserDao userdao) {
        super(userdao);
    }

    // 为目标对象生成内存中的代理对象
    public UserDao getProxyInstance() {
        UserDao userDao = getBusiness();
        return (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    log.info("Log: start function execution");

                    // 执行目标对象方法, 可以获取返回值, 不过此demo没有使用
                    Object returnValue = method.invoke(userDao, args);

                    log.info("Log: end of function execution");
                    return null;
                });
    }
}