package org.example.design.structural.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lombok.extern.log4j.Log4j2;

/**
 *  枚举单例类
 *
 * Author: GL
 * Date: 2021-10-31
 */
@Log4j2
public enum StudentFactory {
    ;

    // 持有缓存-使用线程安全map:
    private static final Map<Integer, Student> CACHE = new ConcurrentHashMap<>();

    public static Student create(int id, String name) {
        Student std = CACHE.getOrDefault(id, null);
        if (std == null) {
            log.info(String.format("create new Student(%s, %s)", id, name));
            std = new Student(id, name);
            CACHE.put(id, std);
        } else {
            log.info(String.format("return cached Student:%s", std));
        }
        return std;
    }
}
