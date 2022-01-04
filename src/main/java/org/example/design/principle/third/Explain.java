package org.example.design.principle.third;

import lombok.extern.log4j.Log4j2;

/**
 *  依赖倒置原则：https://app.yinxiang.com/fx/c2784ddf-be3b-4487-be0d-1681afe3abeb
 *
 *  依赖倒置原则在面向对象中十分常见，几乎所有的项目都会遵守，此23种设计模式中更是经常出现。其核心思想是：要面向接口编程，不要面向实现编程。
 *  依赖倒置原则是实现开闭原则的重要途径之一，它降低了客户与实现模块之间的耦合。
 *
 *  由于在软件设计中，细节具有多变性，而抽象层则相对稳定，因此以抽象为基础搭建起来的架构要比以细节为基础搭建起来的架构要稳定得多。这里的抽象指的是接口或者抽象类，而细节是指具体的实现类。
 *
 *  依赖倒置原则的目的是通过要面向接口的编程来降低类间的耦合性，所以我们在实际编程中只要遵循以下4点，就能在项目中满足这个规则。
 *      1.  每个类尽量提供接口或抽象类，或者两者都具备。
 *      2.  变量的声明类型尽量是接口或者是抽象类。
 *      3.  任何类都不应该从具体类派生。
 *      4.  使用继承时尽量遵循里氏替换原则。
 *      5.  高层模块不应该依赖低层模块[即抽象类不能依赖真正的子类实现类，而应该调用抽象]
 *
 * Author: GL
 * Date: 2021-12-08
 */
public class Explain {
}

/**
 * 反例：具体Jim人类
 *
 * 下面代码看起来比较简单, 但其实是一个非常脆弱的设计. 现在Jim可以吃苹果了, 但是不能只吃苹果而不吃别的水果啊, 这样下去肯定会造成营养失衡. 现在想让Jim吃香蕉了（好像香蕉里含钾元素比较多, 吃点比较有益）, 突然发现Jim
 * 是吃不了香蕉的, 那怎么办呢？看来只有修改代码了啊, 由于上面代码中Jim类依赖于Apple类, 所以导致不得不去改动Jim类里面的代码. 那如果下次Jim
 * 又要吃别的水果了呢？继续修改代码？这种处理方式显然是不可取的, 频繁修改会带来很大的系统风险, 改着改着可能就发现Jim不会吃水果了.
 *
 * 上面的代码之所以会出现上述难堪的问题, 就是因为Jim类依赖于Apple类, 两者是紧耦合的关系, 其导致的结果就是系统的可维护性大大降低. 要增加香蕉类却要去修改Jim类代码, 这是不可忍受的, 你改你的代码为什么要动我的啊, 显然Jim
 * 不乐意了. 我们常说要设计一个健壮稳定的系统, 而这里只是增加了一个香蕉类, 就要去修改Jim类, 健壮和稳定还从何谈起.
 *
 * 而根据依赖倒置原则, 我们可以对上述代码做些修改, 提取抽象的部分. 首先我们提取出两个接口：People和Fruit, 都提供各自必需的抽象方法, 这样以后无论是增加Jim人类, 还是增加Apple、Banana
 * 等各种水果, 都只需要增加自己的实现类就可以了. 由于遵循依赖倒置原则, 只依赖于抽象, 而不依赖于细节, 所以增加类无需修改其他类.
 */
@Log4j2
class Jim {
    public void eat(Apple apple) {
        log.info(String.format("Counterexample: Jim eat: %s ", apple.getName()));
    }
}
//具体苹果类
class Apple {
    public String getName() {
        return "apple";
    }
}


/**
 * 正例：人接口
 *
 *  People和Fruit接口都是复杂的业务逻辑, 属于高层模块, 而Apple2属于低层模块. People依赖于抽象的Fruit接口, 这就做到了：高层模块不应该依赖低层模块, 两者都应该依赖于抽象（抽象类或接口）.
 *  People和Fruit接口与各自的实现类没有关系, 增加实现类不会影响接口, 这就做到了：抽象（抽象类或接口）不应该依赖于细节（具体实现类）.
 *  Jim、Apple、Banana实现类都要去实现各自的接口所定义的抽象方法, 所以是依赖于接口的. 这就做到了：细节（具体实现类）应该依赖抽象.
 */
interface People {
    void eat(Fruit fruit); //将吃的细节抽象, 并且面向抽象类参数
}
//水果接口
interface Fruit {
    String getName(); //将获取水果名的细节抽象
}
//具体Jim人类
@Log4j2
class Jim2 implements People {
    public void eat(Fruit fruit) {
        log.info(String.format("Positive example: Jim eat: %s ", fruit.getName()));
    }
}
//具体苹果类
class Apple2 implements Fruit {
    public String getName() {
        return "apple";
    }
}
//具体香蕉类
class Banana implements Fruit {
    public String getName() {
        return "banana";
    }
}
