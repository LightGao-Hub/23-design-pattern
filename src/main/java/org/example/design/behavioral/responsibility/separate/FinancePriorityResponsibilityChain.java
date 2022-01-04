package org.example.design.behavioral.responsibility.separate;

import java.util.Map;

import lombok.extern.log4j.Log4j2;

/**
 *  公司财务实现的基于优先级责任链容器实现类
 *
 * Author: GL
 * Date: 2021-10-31
 */
@Log4j2
public class FinancePriorityResponsibilityChain<K extends Comparable<K>, V extends FinanceHandler<K>>
        extends PriorityHandlerResponsibilityChain<K, V, FinanceRequest> {

    public void addHandler(V handler) {
        getHandlers().put(handler.getWeight(), handler);
    }

    public boolean process(FinanceRequest financeRequest) {
        // 责任链：依次调用每个Handler并处理
        for (Map.Entry<K, V> entry : getHandlers().entrySet()) {
            V v = entry.getValue();
            Boolean r = v.process(financeRequest);
            if (r != null && r) {
                log.info(String.format("%s Approved by %s", financeRequest, v.getClass().getSimpleName()));
                return r;
            }
        }
        throw new RuntimeException(String.format("Could not handle request: %s", financeRequest));
    }

}
