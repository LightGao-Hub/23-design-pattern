package org.example.design.behavioral.iterator.require.second;

import java.util.Iterator;

/**
 * 符合ReverseArray容器的迭代器
 *
 * Author: GL
 * Date: 2021-11-08
 */
public class ReverseArrayIterator<T> implements Iterator<T> {
    private final T[] array;
    private int index;

    public ReverseArrayIterator(T[] array) {
        this.array = array;
        this.index = this.array.length;
    }

    @Override
    public boolean hasNext() {
        return index > 0;
    }

    @Override
    public T next() {
        index--;
        return array[index];
    }
}
