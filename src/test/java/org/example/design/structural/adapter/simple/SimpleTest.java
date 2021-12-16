package org.example.design.structural.adapter.simple;

import org.junit.Test;

import java.util.concurrent.Callable;

/**
 *  此为适配器模式：
 *      适配器模式是Adapter，是指如果一个接口需要B接口，但是待传入的对象却是A接口，怎么办？
 *
 *      如下例子：
 *
 *          因为Thread接收Runnable接口(这是我们想通过的)，但不接收Callable接口，所以此时如果直接放入callable会报错，怎么办？
 *
 *          一个办法是改写ThreadDemo类，把实现的Callable改为Runnable，但这样做不好，因为ThreadDemo很可能在其他地方作为Callable被引用，那么就需要用到了适配器模式。
 *
 *          不用改写ThreadDemo类，而是使用一个Adapter，把这个Callable接口“变成”Runnable接口，这样，就可以正常编译
 *
 *          因为Thread接收Runnable接口是我们想通过的，所以我们的适配器首先要实现Runnable接口，并将需要适配的ThreadDemo作为适配器的构造参数，由此再在run函数中调用ThreadDemo的call即可！
 *
 *          不过此适配器又一个问题是，Callable接口的call是支持有返回值的，而run函数并不支持返回值，但此适配器只是单纯的实现设计模式，所以此问题并不在考虑范围内;
 *
 *      注意：适配器虽然方便，但会增加项目的复杂性，过多地使用适配器，会让系统非常零乱，不易整体进行把握。比如，明明看到调用的是 A 接口，其实内部被适配成了 B 接口的实现，
 *              一个系统如果太多出现这种情况，无异于一场灾难。因此如果不是很有必要，可以不使用适配器，而是直接对系统进行重构。
 *
 *      总结：所以适配器不是在详细设计时添加的，而是解决正在服役的项目的问题。
 *
 * Author: GL
 * Date: 2021-10-28
 */
public class SimpleTest {
    @Test
    public void test() {
        Callable<Long> callable = new ThreadDemo(123456);
        Thread thread = new Thread(new RunnableAdapter(callable));
        thread.start();
    }
}
