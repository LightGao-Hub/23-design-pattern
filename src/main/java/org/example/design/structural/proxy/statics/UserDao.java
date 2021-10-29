package org.example.design.structural.proxy.statics;

/**
 *  代理模式的前提是必须要有相同的接口！
 * Author: GL
 * Date: 2021-10-09
 */
public interface UserDao {
    public void save(String name);
    public void update();
}
