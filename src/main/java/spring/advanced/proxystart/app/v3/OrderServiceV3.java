package spring.advanced.proxystart.app.v3;

import org.springframework.stereotype.Service;
import spring.advanced.proxystart.app.v2.OrderRepositoryV2;

@Service
public class OrderServiceV3 {
    private final OrderRepositoryV3 orderRepository;

    public OrderServiceV3(OrderRepositoryV3 orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
