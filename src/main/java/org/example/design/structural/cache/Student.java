package org.example.design.structural.cache;

import lombok.Data;

import java.util.Random;

/**
 *  学生类
 *
 * Author: GL
 * Date: 2021-10-31
 */
@Data
public class Student {

    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
