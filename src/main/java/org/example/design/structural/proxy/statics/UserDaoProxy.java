package org.example.design.structural.proxy.statics;

/**
 *  静态代理类
 * Author: GL
 * Date: 2021-10-28
 */
public class UserDaoProxy implements UserDao {

    private final UserDao dao;

    public UserDaoProxy(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(String name) {
        System.out.println("开启事务");//额外扩展了功能
        dao.save(name);
        System.out.println("提交事务");
    }

    @Override
    public void update() {
        System.out.println("开启事务");//额外扩展了额外功能
        dao.update();
        System.out.println("提交事务");
    }
}
