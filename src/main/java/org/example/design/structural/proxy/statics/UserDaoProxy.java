package org.example.design.structural.proxy.statics;

import lombok.extern.log4j.Log4j2;

/**
 *  静态代理类
 * Author: GL
 * Date: 2021-10-28
 */
@Log4j2
public class UserDaoProxy implements UserDao {

    private final UserDao dao;

    public UserDaoProxy(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(String data) {
        log.info("Open transaction"); //额外扩展了功能
        dao.save(data);
        log.info("Commit transaction");
    }

    @Override
    public void update() {
        log.info("Open transaction"); //额外扩展了功能
        dao.update();
        log.info("Commit transaction");
    }
}
