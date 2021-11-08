package org.example.design.behavioral.iterator.begin.two;


import java.util.Iterator;

/**
 *  此案例用来解决案例以及为何使用内部类解释
 *
 *  从下面的案例中我们能够看出抽离出Iterable的好处就是可以让集合在各个线程或传递中的迭代器分离；
 *
 *  如果此时又一个新集合reverseLinkedList 那么依然是继承Iterable然后创建一个reverseLinkedIterator即可
 *
 *  缺点：
 *      由于我们的ReverseArrayIterator 只适用于 ReverseArrayCollection集合！ 并且还需要将array引用进行传递！
 *      那么我们完全没必要单独在外部建一个类，而是采用内部类的方式，在ReverseArrayCollection创建一个内部类ReverseArrayIterator 即可，还无需传递array引用！
 *
 *      参考 complete代码
 *
 * Author: GL
 * Date: 2021-11-08
 */
public class Test {
    public static void main(String[] args) {
        Iterable<Integer> iterable = new ReverseArrayCollection<>();
        // 每个线程通过iterable.iterator() 返回迭代器进行迭代，从而保证从到到位执行
        new Thread(() -> {
            final Iterator<Integer> iterator = iterable.iterator();
            while (iterator.hasNext()) {
                System.out.println(String.format(" %s - %s", Thread.currentThread().getName(), iterator.next()));
            }
        }).start();
        new Thread(() -> {
            final Iterator<Integer> iterator = iterable.iterator();
            while (iterator.hasNext()) {
                System.out.println(String.format(" %s - %s", Thread.currentThread().getName(), iterator.next()));
            }
        }).start();
    }

}
