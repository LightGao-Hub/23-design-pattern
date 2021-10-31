package org.example.design.structural.flyweight;

import lombok.Data;

import java.util.Random;

/**
 *  深圳的学生，实现Student接口
 *
 * Author: GL
 * Date: 2021-10-31
 */
@Data
public class Student {

    private static Random RAND = new Random(); // 静态变量方便获取随机值

    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
