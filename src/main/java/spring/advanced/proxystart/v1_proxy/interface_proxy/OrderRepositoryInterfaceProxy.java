package spring.advanced.proxystart.v1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import spring.advanced.proxystart.app.v1.OrderRepositoryV1;
import spring.advanced.proxystart.trace.TraceStatus;
import spring.advanced.proxystart.trace.logTrace.LogTrace;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {

    private final OrderRepositoryV1 target;
    private final LogTrace logTrace;

    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderRepository.save()");
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
