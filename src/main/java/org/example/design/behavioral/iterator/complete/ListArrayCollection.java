package org.example.design.behavioral.iterator.complete;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 *  此为简易版arraylist, 实现线程安全及add/remove操作 & 实现迭代器过程中如果remove删除元素报错
 *
 * Author: GL
 * Date: 2021-11-08
 */
@Data
@Log4j2
public class ListArrayCollection<T> implements ArrayCollection<T> {
    private T[] array;
    private int length;
    private int currentIndex;
    private int modCount; // modCount用来记录集合被修改的次数
    private final int defaultLength = 5;

    @SafeVarargs
    public ListArrayCollection(T... objs) {
        array = Arrays.copyOfRange(objs, 0, objs.length);
        length = array.length;
        currentIndex = length;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    @Override
    public synchronized boolean add(T e) {
        addCheck();
        array[currentIndex++] = e;
        return true;
    }

    @Override
    public synchronized boolean remove(int index) {
        if (index >= 0 && index < currentIndex) {
            modCount++;
            for (int i = index; i < currentIndex - 1; i++) {
                array[i] = array[i + 1];
            }
            array[--currentIndex] = null;
            removeCheck();
            return true;
        }
        log.info("不存在的下标");
        return false;
    }

    /**
     * 删除值之后调整容量检查
     */
    private void removeCheck() {
        if (currentIndex < length / 2) {
            length = length / 2;
            adjustCapacity();
        }
    }

    /**
     * 添加值之后调整容量检查
     */
    private void addCheck() {
        if (currentIndex >= length) {
            length = length == 0 ? defaultLength : (length >> 1) + length; // 扩张1.5倍
            adjustCapacity();
        }
    }

    /**
     * 扩展容量
     */
    private void adjustCapacity() {
        array = Arrays.copyOf(array, length);
    }

    /**
     *  内部类实现Iterator, 使用内部类的方便之处在于可以无形中引用外部类中的变量, 如下：index、modCount等变量;
     */
    private final class ListIterator implements Iterator<T> {
        int index;
        int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return index < currentIndex;
        }

        @Override
        public T next() {
            checkForComodification(); //判断集合元素是否更改
            if (this.hasNext()) {
                return array[index++];
            }
            return null;
        }

        // 当集合中modCount 和 初始化迭代器时的expectedModCount不一样时, 代表元素更改, 抛出异常
        private void checkForComodification() {
            if (modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
