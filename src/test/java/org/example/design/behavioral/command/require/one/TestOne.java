package org.example.design.behavioral.command.require.one;

import org.junit.Test;

/**
 *  此案例为简单版命令函数：
 *      1、Simple类的fun函数默认是两个参数相加，假设后面产品更改需求想变成为相减，后面再换成相乘或相除，如何保证可扩展性？
 *      2、此时可以使用命令模式，将Simple类重新设计成SimpleCommand类，fun函数的入参为Operation类，直接调用operation函数即可！
 *      3、通过将函数的执行逻辑抽象成类，通过继承扩展来解决此函数的未来扩展问题，符合开闭原则！
 *      4、此写法为函数级别的命令模式，真正实战当中我们一般使用类级别的命令模式，详细看two/three包
 *
 * Author: GL
 * Date: 2021-12-27
 */
public class TestOne {
    @Test
    public void test() {
        final SimpleCommand simpleCommand = new SimpleCommand();
        simpleCommand.fun(new SumOperation(1, 2));
        simpleCommand.fun(new SubtractOperation(1, 2));
    }
}
