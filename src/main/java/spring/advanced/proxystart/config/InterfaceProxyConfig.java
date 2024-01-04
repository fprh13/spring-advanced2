package spring.advanced.proxystart.config;

import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.advanced.proxystart.app.v1.*;
import spring.advanced.proxystart.trace.logTrace.LogTrace;
import spring.advanced.proxystart.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import spring.advanced.proxystart.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import spring.advanced.proxystart.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;

@Configuration
public class InterfaceProxyConfig {

    @Bean
    public OrderControllerV1 orderController(LogTrace logTrace) {
        OrderControllerV1Impl controllerImpl = new OrderControllerV1Impl(orderService(logTrace));
        return new OrderControllerInterfaceProxy(controllerImpl,logTrace);
    }

    @Bean // Bean 으로 등록하니까 public
    public OrderServiceV1 orderService(LogTrace logTrace) {
        OrderServiceV1Impl serviceImpl = new OrderServiceV1Impl(orderRepository(logTrace));
        return new OrderServiceInterfaceProxy(serviceImpl, logTrace);
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace) {
        OrderRepositoryV1Impl repositoryImpl = new OrderRepositoryV1Impl();
        return new OrderRepositoryInterfaceProxy(repositoryImpl, logTrace);
    }


}
