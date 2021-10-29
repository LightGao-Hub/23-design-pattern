package org.example.design.structural.proxy.dynamic;

/**
 * Author: GL
 * Date: 2021-10-09
 */
public class UserDaoImpl implements UserDao {

    public void save(String name) {
        System.out.println("保存数据 name:" + name);
    }

    public void update() {
        System.out.println("修改数据");
    }
}
