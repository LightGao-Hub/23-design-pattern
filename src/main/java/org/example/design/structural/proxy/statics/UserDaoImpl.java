package org.example.design.structural.proxy.statics;

import lombok.extern.log4j.Log4j2;

/**
 *  业务类
 * Author: GL
 * Date: 2021-10-09
 */
@Log4j2
public class UserDaoImpl implements UserDao {

    public void save(String data) {
        log.info(String.format("Save data: %s", data));
    }

    public void update() {
        log.info("Modify data");
    }
}
