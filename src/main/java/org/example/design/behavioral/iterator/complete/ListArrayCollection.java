package org.example.design.behavioral.iterator.complete;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Author: GL
 * Date: 2021-11-08
 */
public class ListArrayCollection<T> implements ArrayCollection<T> {
    private T[] array;
    private int length;
    private int currentIndex;
    // modCount用来记录集合被修改的次数
    private int modCount;
    private final int defaultLength = 5;

    @SafeVarargs
    public ListArrayCollection(T... objs) {
        this.array = Arrays.copyOfRange(objs, 0, objs.length);
        this.length = this.array.length;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    @Override
    public synchronized boolean add(T e) {
        capacityCheck();
        this.array[currentIndex++] = e;
        this.modCount++;
        return true;
    }

    // 扩容检查
    private void capacityCheck() {
        if (this.currentIndex >= this.length) {
            this.length = this.length == 0 ? this.defaultLength : (this.length >> 1) + this.length; // 扩张1.5倍
            this.array = Arrays.copyOf(this.array, this.length);
        }
    }

    // 内部类实现Iterator，使用内部类的方便之处在于可以无形中引用外部类中的变量，如下使用index < array.length 十分方便;
    private final class ListIterator implements Iterator<T> {

        int index;
        int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return index < array.length;
        }

        @Override
        public T next() {
            checkForComodification(); //判断元素是否更改
            if (this.hasNext()) {
                return array[index++];
            }
            return null;
        }

        // 当初始化迭代器时的modCount和 集合中expectedModCount不一样时，代表元素更改，抛出异常
        private void checkForComodification() {
            if (modCount != this.expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
}
