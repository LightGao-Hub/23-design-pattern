package org.example.design.behavioral.template;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  模版模式是一种行为设计模式, 它在基类中定义了一个算法的框架, 允许子类在不修改结构的情况下重写算法的特定步骤.
 *
 *  在本例中, 模版方法模式定义了一个可与社交网络协作的算法. 与特定社交网络相匹配的子类将根据社交网络所提供的 API 来实现这些步骤.
 *
 *  结构：
 *                         模型类
 *                    ┌─────────────┐
 *                    │Network      │
 *                    │ └post(){}   │
 *                    │ └logIn()    │
 *                    │ └sendData() │
 *                    │ └logOut()   │
 *                    └─────────────┘
 *                          ▲
 *          ┌───────────────┼───────────────┐
 *   ┌──────────────┐               ┌───────────────┐
 *   │Facebook      │               │Twitter        │
 *   │ └logIn(){}   │               │ └logIn(){}    │
 *   │ └sendData(){}│               │ └sendData(){} │
 *   │ └logOut(){}  │               │ └logOut(){}   │
 *   └──────────────┘               └───────────────┘
 *
 *
 *  总结：
 *      模板模式应用比较广泛, 当我们知道核心业务员逻辑不变, 而部分业务需要扩展时, 可以使用此模式！
 *
 *      在调度系统grus项目[待开源], grus-worker模块下的AbstractExecutor类中就使用了模板模式, 由不同的执行器来创建不同的shell脚本
 *
 * Author: GL
 * Date: 2021-11-22
 */
@Log4j2
public class TestTemplate {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Network network = null;
        System.out.print("Input user name: ");
        String userName = reader.readLine();
        System.out.print("Input password: ");
        String password = reader.readLine();

        System.out.print("Input message: ");
        String message = reader.readLine();

        log.info("\nChoose social network for posting message.\n" +
                "1 - Facebook\n" +
                "2 - Twitter");
        int choice = Integer.parseInt(reader.readLine());

        if (choice == 1) {
            network = new Facebook(userName, password);
        } else if (choice == 2) {
            network = new Twitter(userName, password);
        }
        assert network != null;
        network.post(message);
    }
}
