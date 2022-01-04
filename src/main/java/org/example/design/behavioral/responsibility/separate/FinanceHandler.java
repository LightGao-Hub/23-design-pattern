package org.example.design.behavioral.responsibility.separate;

import lombok.Getter;

/**
 *  财务处理器抽象类, 其中weight为权重, 需实现Comparable
 *
 * Author: GL
 * Date: 2021-10-31
 */
public abstract class FinanceHandler<T extends Comparable<T>> implements Handler {
    // 权重值
    @Getter
    private final T weight;

    protected FinanceHandler(T weight) {
        this.weight = weight;
    }

    // 返回Boolean.TRUE = 成功；返回Boolean.FALSE = 拒绝；返回null = 交下一个处理
    abstract Boolean process(FinanceRequest financeRequest);
}
