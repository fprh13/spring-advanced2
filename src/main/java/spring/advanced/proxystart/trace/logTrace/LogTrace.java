package spring.advanced.proxystart.trace.logTrace;


import spring.advanced.proxystart.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
