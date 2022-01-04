package org.example.design.behavioral.iterator.complete;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

/**
 *  此案例是完整版迭代器模式, 且实现了当迭代器运行时添加集合元素会报错的特点.
 *  通过内部类会默认拥有外部类的成员变量的特点, 即便通过iterator()拿到多个内部类, 其内部依然引用同一父类成员变量, 得以实现迭代过程中添加或删除元素报错的特点
 *
 *  结构：
 *        接口
 *    ┌────────────┐                                    迭代器
 *    │ Iterable   │                                 ┌───────────┐
 *    │ └iterator()│<--------------------------------│ Iterator  │
 *    └────────────┘                                 │ └hasNext()│
 *         ▲                                         │ └next()   │
 *         │                                         └───────────┘
 *         │                                              ▲
 *         │                                              │
 *    ┌────────────────┐                                  │
 *    │ ArrayCollection│                                  │
 *    └────────────────┘                                  │
 *         ▲                                              │
 *         │                                              │
 *         │                                              │
 *         │                                              │
 *         │                                              │
 *    ┌────────────────────────────────────────────┐      │
 *    │ ListArrayCollection                        │      │
 *    │ └iterator(){new ListIterator()}            │      │
 *    │   └class ListIterator implements Iterator{}│------┘
 *    │     └hasNext(){}                           │
 *    │     └next(){}                              │
 *    └────────────────────────────────────────────┘
 *
 *  总结：通过模拟ArrayList集合可以发现使用内部类的方式最为优雅, 同时也实现了迭代器模型
 *
 * Author: GL
 * Date: 2021-11-08
 */
@Log4j2
public class TestComplete {
    @Test
    public void test() {
        ArrayCollection<Integer> integers = new ListArrayCollection<>(1, 2, 3, 4, 5, 6);

        new Thread(() -> {
            for (Integer integer : integers) {
                log.info(String.format(" %s - %s", Thread.currentThread().getName(), integer));
            }
        }).start();

        // 此时插入元素不报错
        integers.add(7);
        integers.add(8);

        new Thread(() -> {
            for (Integer integer : integers) {
                log.info(String.format(" %s - %s", Thread.currentThread().getName(), integer));
            }
        }).start();

        // 此时删除数据, 迭代器会报错
        // integers.remove(3);
    }
}
