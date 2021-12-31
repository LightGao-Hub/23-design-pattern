package org.example.design.behavioral.command.require.one;

import lombok.Getter;

/**
 *  此案例为简单版命令函数：
 *      1、Simple类的fun函数默认是两个参数相加，假设后面产品更改需求想变成为相减，后面再换成相乘或相除，如何保证可扩展性？
 *      2、此时可以使用命令模式，将Simple类重新设计成SimpleCommand类，fun函数的入参为Operation类，直接调用operation函数即可！
 *      3、通过将函数的执行逻辑抽象成类，解决此函数的未来扩展问题，符合开闭原则！
 *      4、此写法为函数级别的命令模式，真正实战当中我们一般使用类级别的命令模式，详细看two/three包
 *
 * Author: GL
 * Date: 2021-12-27
 */
public class SimpleCommand {
    public void fun(Operation operation) {
        operation.operation();
    }
}

class Simple {
    public void fun(int count1, int count2) {
        System.out.println(count1 + count2);
    }
}

abstract class Operation {
    @Getter
    private final int count1;
    @Getter
    private final int count2;
    protected Operation(int count1, int count2) {
        this.count1 = count1;
        this.count2 = count2;
    }
    public abstract void operation();
}

class SumOperation extends Operation {
    SumOperation(int count1, int count2) {
        super(count1, count2);
    }
    @Override
    public void operation() {
        System.out.println(super.getCount1() + super.getCount2());
    }
}

class SubtractOperation extends Operation {
    SubtractOperation(int count1, int count2) {
        super(count1, count2);
    }
    @Override
    public void operation() {
        System.out.println(super.getCount1() - super.getCount2());
    }
}

