package spring.advanced.proxystart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.advanced.proxystart.app.v1.*;

@Configuration
public class AppV1Config {

    @Bean
    public OrderControllerV1 orderControllerV1() {
        return new OrderControllerV1Impl(orderServiceV1());
    }

    @Bean // Bean 으로 등록하니까 public
    public OrderServiceV1 orderServiceV1() {
        return new OrderServiceV1Impl(orderRepositoryV1());
    }

    @Bean
    public OrderRepositoryV1 orderRepositoryV1() {
        return new OrderRepositoryV1Impl();
    }
}
