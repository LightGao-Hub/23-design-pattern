package org.example.design.creative.factory.simple.factory1;

import lombok.Data;

/**
 *  简单对象
 *
 * Author: GL
 * Date: 2021-11-25
 */
@Data
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }
}
