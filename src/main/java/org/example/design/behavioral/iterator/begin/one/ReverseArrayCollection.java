package org.example.design.behavioral.iterator.begin.one;

import lombok.Data;

import java.util.Arrays;
import java.util.Iterator;

/**
 *  集合类：暂不考虑集合元素修改情况
 *
 * Author: GL
 * Date: 2021-11-08
 */
@Data
public class ReverseArrayCollection<T> implements Iterator<T> {

    private final T[] array;
    // 索引位置:
    private int index;

    public ReverseArrayCollection(T... objs) {
        this.array = Arrays.copyOfRange(objs, 0, objs.length);
        this.index = this.array.length;
    }

    @Override
    public boolean hasNext() {
        // 如果索引大于0,那么可以移动到下一个元素(倒序往前移动):
        return index > 0;
    }

    @Override
    public T next() {
        // 将索引移动到下一个元素并返回(倒序往前移动):
        index--;
        return array[index];
    }
}
