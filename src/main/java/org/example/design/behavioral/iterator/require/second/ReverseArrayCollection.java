package org.example.design.behavioral.iterator.require.second;

import java.util.Arrays;
import java.util.Iterator;

/**
 *  集合类：实现Iterable接口
 *  暂不考虑集合元素修改情况
 *
 * Author: GL
 * Date: 2021-11-08
 */
public class ReverseArrayCollection<T> implements Iterable<T> {

    private final T[] array;

    @SafeVarargs
    public ReverseArrayCollection(T... objs) {
        this.array = Arrays.copyOfRange(objs, 0, objs.length);
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator<>(array);
    }
}
