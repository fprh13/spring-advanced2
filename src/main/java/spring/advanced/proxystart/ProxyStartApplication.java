package spring.advanced.proxystart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import spring.advanced.proxystart.config.AppV1Config;
import spring.advanced.proxystart.config.AppV2Config;
import spring.advanced.proxystart.config.InterfaceProxyConfig;
import spring.advanced.proxystart.config.LogTraceConfig;
import spring.advanced.proxystart.trace.logTrace.LogTrace;
import spring.advanced.proxystart.trace.logTrace.ThreadLocalLogTrace;

@Import({AppV2Config.class, InterfaceProxyConfig.class})
@SpringBootApplication(scanBasePackages = "spring.advanced.proxystart.app")
public class ProxyStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyStartApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}
}
