package spring.advanced.proxystart.app.v3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.advanced.proxystart.app.v2.OrderServiceV2;

// 컴포넌트 스캔으로 스프링 빈 자동 등록
@RestController
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;

    public OrderControllerV3(OrderServiceV3 orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/v3/request")
    public String request(String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }
    @GetMapping("/v3/no-log")
    public String noLog() {
        return "ok";
    }
}
