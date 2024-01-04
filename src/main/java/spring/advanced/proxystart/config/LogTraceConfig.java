package spring.advanced.proxystart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.advanced.proxystart.trace.logTrace.LogTrace;
import spring.advanced.proxystart.trace.logTrace.ThreadLocalLogTrace;

@Configuration
public class LogTraceConfig {

    @Bean // 싱글 톤으로 하나만 인스턴스가 등록 된다.
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
