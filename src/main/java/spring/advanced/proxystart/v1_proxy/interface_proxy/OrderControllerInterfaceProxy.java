package spring.advanced.proxystart.v1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import spring.advanced.proxystart.app.v1.OrderControllerV1;
import spring.advanced.proxystart.trace.TraceStatus;
import spring.advanced.proxystart.trace.logTrace.LogTrace;

@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements OrderControllerV1 {

    private final OrderControllerV1 target;
    private final LogTrace logTrace;


    @Override
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderController.requset()");
            String result = target.request(itemId);
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    @Override
    public String nolog() {
        return target.nolog();
    }
}
