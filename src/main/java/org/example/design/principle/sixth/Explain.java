package org.example.design.principle.sixth;

import lombok.extern.log4j.Log4j2;

/**
 *  开闭原则, 详细请看：https://app.yinxiang.com/fx/7cc75f29-bc1e-4260-96eb-c80e9200ba2c
 *
 *  定义：一个软件实体如类、模块和函数应该对扩展开放, 对修改关闭.
 *
 *  问题由来：在软件的生命周期内, 因为变化、升级和维护等原因需要对软件原有代码进行修改时, 可能会给旧代码中引入错误, 也可能会使我们不得不对整个功能进行重构, 并且需要原有代码经过重新测试.
 *
 *  解决方案：当软件需要变化时, 尽量通过扩展软件实体的行为来实现变化, 而不是通过修改已有的代码来实现变化.
 *
 *  理解：我们遵循设计模式前面5大原则, 以及使用23种设计模式的目的就是遵循开闭原则. 也就是说, 只要我们对前面5项原则遵守的好了, 设计出的软件自然是符合开闭原则的,
 *       这个开闭原则更像是前面五项原则遵守程度的“平均得分”, 前面5项原则遵守的好, 平均分自然就高, 说明软件设计开闭原则遵守的好；如果前面5项原则遵守的不好, 则说明开闭原则遵守的不好.
 *
 *  开闭原则无非就是想表达这样一层意思：用抽象构建框架, 用实现扩展细节. 因为抽象灵活性好, 适应性广, 只要抽象的合理, 可以基本保持软件架构的稳定.
 *      而软件中易变的细节, 我们用从抽象派生的实现类来进行扩展, 当软件需要发生变化时, 我们只需要根据需求重新派生一个实现类来扩展就可以了. 当然前提是我们的抽象要合理, 要对需求的变更有前瞻性和预见性才行.
 *
 *  总结：用抽象构建框架, 用实现扩展细节
 *
 *  如下案例：框架即People, Fruit接口的抽象, 实现细节为Jim, Apple, Banana；人及水果都可以扩展, 由此实现开闭原则.
 *
 * Author: GL
 * Date: 2021-12-13
 */
public class Explain {
}

interface People {
    void eat(Fruit fruit);
}

interface Fruit {
    String getName();
}

@Log4j2
class Jim implements People {
    public void eat(Fruit fruit) {
        log.info("positive example: Jim eat " + fruit.getName());
    }
}
class Apple implements Fruit {
    public String getName() {
        return "apple";
    }
}
class Banana implements Fruit {
    public String getName() {
        return "banana";
    }
}
