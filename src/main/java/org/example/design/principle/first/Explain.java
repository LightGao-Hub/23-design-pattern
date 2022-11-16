package org.example.design.principle.first;

/**
 *  单一职责原则, 详细请看：https://app.yinxiang.com/fx/b6a577e4-53ef-4305-b4fc-752755346262
 *
 *  初学者在编程的时候可能一开始会有这样的经历, 使用一个类来实现很多的功能, 新添加的甚至不相关的功能都放在一个类里来实现, 煮成了一锅大杂烩, 往往使得某个类包罗万象, 无所不能.
 *  可能刚开始实现功能比较简单, 这样做不会引发什么特别大的问题. 但是随着项目复杂度的提升, 各种不相关的实现代码耦合在一起, 一旦有功能的更改或增删, 修改的代码很可能会导致其他功能的正常运行.
 *  这种编程方式显然是不可取的, 也就是违背了所谓的单一职责原则.
 *
 *  在软件设计中, 秉承着“高内聚, 低耦合”的思想, 让一个类仅负责一项职责, 如果一个类有多于一项的职责, 那么就代表这个类耦合性变高了, 这些职责耦合在了一起, 这是比较脆弱的设计.
 *  因为一旦某一项职责发生了改变, 需要去更改代码, 那么有可能会引起其他职责改变. 所谓牵一发而动全身, 这显然是我们所不愿意看到的,
 *  所以我们会把这个类分拆开来, 由两个类来分别维护这两个职责, 这样当一个职责发生改变, 需要修改时, 不会影响到另一个职责.
 *
 *  单一职责原则的核心就是一个类只负责一类职责！
 *
 *  例如：
 *      1、redisUtil工具类只负责redis的常用操作，至于在redis之上的业务需求则需要在上层创建service业务类
 *      2、arrayList类就只有围绕着集合的一类职责！即便有add, remove等多个函数, 但职责都是围绕着集合系列
 *      3、备忘录模式中最少需要抽象成三个类, 因为每个类负责一个职责, 详细参看[behavioral.memento包]
 *
 * Author: GL
 * Date: 2021-12-08
 */
public class Explain {
}