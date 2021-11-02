package org.example.design.behavioral.responsibility.separate;

import java.util.Map;

/**
 *  公司财务实现的基于优先级责任链处理类
 *
 * Author: GL
 * Date: 2021-10-31
 */
public class FinancePriorityResponsibilityChain<K extends Comparable<K>, V extends FinanceHandler<K>> extends PriorityHandlerResponsibilityChain<K, V> {

    public void addHandler(V handler) {
        super.getHandlers().put(handler.weight, handler);
    }

    public boolean process(FinanceRequest financeRequest) {
        // 责任链：依次调用每个Handler并处理
        for (Map.Entry<K, V> entry : super.getHandlers().entrySet()) {
            V v = entry.getValue();
            Boolean r = v.process(financeRequest);
            if (r != null && r) {
                System.out.println(String.format("%s Approved by %s", financeRequest, v.getClass().getSimpleName()));
                return r;
            }
        }
        throw new RuntimeException(String.format("Could not handle request: %s", financeRequest));
    }

}
