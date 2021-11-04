package org.example.design.structural.flyweight;

import com.sun.tools.javac.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: GL
 * Date: 2021-10-31
 */
public class StudentFactory {

    // 持有缓存-使用线程安全map:
    private static final Map<Integer, Student> cache = new ConcurrentHashMap<>();

    public static Student create(int id, String name) {
        Assert.check(id >= 0);
        Assert.check(name != null);
        Student std = cache.getOrDefault(id, null);
        // 缓存中存在:
        if (std == null) {
            // 未找到,创建新对象:
            System.out.println(String.format("create new Student(%s, %s)", id, name));
            std = new Student(id, name);
            // 放入缓存:
            cache.put(id, std);
        } else {
            System.out.println(String.format("return cached Student:%s", std));
        }
        return std;
    }
}
