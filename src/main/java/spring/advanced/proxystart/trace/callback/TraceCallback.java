package spring.advanced.proxystart.trace.callback;

public interface TraceCallback<T> {

    T call();
}
