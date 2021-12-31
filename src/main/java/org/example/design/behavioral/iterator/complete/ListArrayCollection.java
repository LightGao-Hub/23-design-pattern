package org.example.design.behavioral.iterator.complete;

import lombok.Data;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 *  此为简易版arraylist，实现线程安全及add/remove操作 & 实现迭代器过程中如果remove删除元素报错
 *
 * Author: GL
 * Date: 2021-11-08
 */
@Data
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
        this.currentIndex = this.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    @Override
    public synchronized boolean add(T e) {
        addCheck();
        this.array[currentIndex++] = e;
        return true;
    }

    @Override
    public synchronized boolean remove(int index) {
        if (index >= 0 && index < this.currentIndex) {
            this.modCount++;
            // 将此index以后的值往前移动一位, 不过会导致currentIndex的前一位为空，所以将currentIndex前一位设置为Null，并且自减
            for (int i = index; i < this.currentIndex - 1; i++) {
                this.array[i] = this.array[i + 1];
            }
            this.array[--this.currentIndex] = null;
            this.removeCheck();
            return true;
        }
        System.out.println("不存在的下标");
        return false;
    }

    /**
     * 删除值之后调整容量检查
     */
    private void removeCheck() {
        if (this.currentIndex < this.length / 2) {
            this.length = this.length / 2;
            this.adjustCapacity();
        }
    }

    /**
     * 添加值之后调整容量检查
     */
    private void addCheck() {
        if (this.currentIndex >= this.length) {
            this.length = this.length == 0 ? this.defaultLength : (this.length >> 1) + this.length; // 扩张1.5倍
            this.adjustCapacity();
        }
    }

    /**
     * 扩展容量
     */
    private void adjustCapacity() {
        this.array = Arrays.copyOf(this.array, this.length);
    }

    /**
     *  内部类实现Iterator，使用内部类的方便之处在于可以无形中引用外部类中的变量，如下：index、modCount等变量;
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

        // 当集合中modCount 和 初始化迭代器时的expectedModCount不一样时，代表元素更改，抛出异常
        private void checkForComodification() {
            if (modCount != this.expectedModCount) throw new ConcurrentModificationException();
        }
    }
}
