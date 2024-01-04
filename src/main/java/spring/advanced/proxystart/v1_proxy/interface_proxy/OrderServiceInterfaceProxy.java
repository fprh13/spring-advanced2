package spring.advanced.proxystart.v1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import spring.advanced.proxystart.app.v1.OrderServiceV1;
import spring.advanced.proxystart.trace.TraceStatus;
import spring.advanced.proxystart.trace.logTrace.LogTrace;

@RequiredArgsConstructor
public class OrderServiceInterfaceProxy implements OrderServiceV1 {

    private final OrderServiceV1 target;
    private final LogTrace logTrace;

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderRepository.orderItem()");
            target.orderItem(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
