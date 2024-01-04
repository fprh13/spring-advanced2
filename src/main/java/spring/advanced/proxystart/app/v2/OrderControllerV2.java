package spring.advanced.proxystart.app.v2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// @RequestMapping 은 3.x 버젼에서는 등록이 안됨 controller 제외한 나머지는 인터페이스 없는 구페 클래스로 스프링 빈으로 수동 등록
// 이런 식으로 인터페이스가 없는 클래스를 부채 클래스라고 한다.
@RestController
public class OrderControllerV2 {
    private final OrderServiceV2 orderService;

    public OrderControllerV2(OrderServiceV2 orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/v2/request")
    public String request(String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }
    @GetMapping("/v2/no-log")
    public String noLog() {
        return "ok";
    }

}
