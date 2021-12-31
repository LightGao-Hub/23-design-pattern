package org.example.design.behavioral.memento.simple;

import org.junit.Test;

/**
 *
 *  此案例为备忘录模式的标准使用：符合单一职责设计原则！
 *
 *  结构：
 *           发起人接口[需要被备份的类]          负责人接口[负责存储和管理备忘录集合]  备忘录[保存状态]
 *        ┌───────────────────────────┐     ┌───────────────────────────┐   ┌───────────┐
 *        │ Originator                │     │ Caretaker                 │   │ Memento   │
 *        │  └createMemento()         │     │  └CopyOnWriteArrayList<>  │   │  └state<> │
 *        │  └restoreMemento(Memento) │     └───────────────────────────┘   └───────────┘
 *        └───────────────────────────┘
 *                    ▲                    ┌───────────┐
 *                    │------------------->│ Cloneable │  克隆接口
 *               ┌──────────┐              └───────────┘
 *               │GameRole  │
 *               └──────────┘
 *
 *
 *  不足：
 *      1、不难看出此备忘录的负责人Caretaker引用只有main函数的用户管理，这在实战中是不可能的，一般是结合业务，有一个类持有Caretaker引用，
 *          并且备忘录模式可以和命令行模式进行结合，参考[complete]包
 *      2、GameRole的克隆方式可以升级为原型模式，参考[creative.prototype.complete.usually包]
 *
 * Author: GL
 * Date: 2021-11-15
 */
public class TestSimple {
    @Test
    public void test() {
        // 创建角色
        GameRole role = new GameRole(100.0, 100.0);
        // 创建存档
        final Caretaker<GameRole> caretaker = new Caretaker<>();
        // 参战
        role.fight();
        // 存档
        final int one = caretaker.saveMemento(role.createMemento());
        // 参战
        role.fight();
        // 存档
        final int two = caretaker.saveMemento(role.createMemento());
        // 参战
        role.fight();
        // 存档
        final int three = caretaker.saveMemento(role.createMemento());
        // 打印
        System.out.println(caretaker);
        // 回滚到第二次战斗的存档
        role.restoreMemento(caretaker.retrieveMemento(two));
        // 打印回滚后的角色
        System.out.println(role);
    }
}
