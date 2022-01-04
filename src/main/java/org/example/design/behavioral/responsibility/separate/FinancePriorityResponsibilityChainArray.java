package org.example.design.behavioral.responsibility.separate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import lombok.extern.log4j.Log4j2;

/**
 *  集合模式的排序, 已废弃, 只供参考
 *
 * Author: GL
 * Date: 2021-10-31
 */
@Deprecated
@Log4j2
public class FinancePriorityResponsibilityChainArray<T extends Comparable<T>> {
    // 持有所有Handler
    private final List<FinanceHandler<T>> financeHandlers = new ArrayList<>();

    public void  addHandler(FinanceHandler<T> financeHandler) {
        this.financeHandlers.add(financeHandler);
    }

    public boolean process(FinanceRequest financeRequest) {
        // 先进行排序, 
        financeHandlers.sort(Comparator.comparing(o -> o.getWeight()));
        // 依次调用每个Handler:
        for (FinanceHandler<T> financeHandler : financeHandlers) {
            Boolean r = financeHandler.process(financeRequest);
            if (r != null) {
                // 如果返回TRUE或FALSE, 处理结束:
                log.info(financeRequest + " " + (r ? "Approved by " : "Denied by ") + financeHandler.getClass().getSimpleName());
                return r;
            }
        }
        throw new RuntimeException("Could not handle request: " + financeRequest);
    }
}
