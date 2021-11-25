package org.example.design.behavioral.memento.simple;

/**
 *
 *  此案例为备忘录模式的标准使用
 *
 *  结构：
 *           发起人接口[需要被备份的类]              负责人接口[存储备忘录]        备忘录[保存状态]
 *        ┌───────────────────────────┐     ┌───────────────────────────┐   ┌───────────┐
 *        │ Originator                │     │ Caretaker                 │   │ Memento   │
 *        │  └createMemento()         │     │  └CopyOnWriteArrayList<>  │   │  └state<> │
 *        │  └restoreMemento(Memento) │     └───────────────────────────┘   └───────────┘
 *        └───────────────────────────┘
 *                    ▲
 *                    │
 *               ┌──────────┐
 *               │GameRole  │
 *               └──────────┘
 *
 *  不足：不难看出此备忘录的负责人Caretaker只在main函数中出现，这在业务层面是不可能的，一般是结合业务有一个类持有，参考[complete]包
 *
 *
 * Author: GL
 * Date: 2021-11-15
 */
public class Test {
    public static void main(String[] args) {
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
