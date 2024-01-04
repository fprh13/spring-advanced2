package spring.advanced.proxystart.app.v1;


import org.springframework.web.bind.annotation.*;

// @RequestMapping 은 3.x 버젼에서는 등록이 안됨 controller 제외한 나머지는 인터페이스롸 구현 크래스 스프링 빈으로 수동 등록
@RestController //스프링은 @Controller, @RestController가 있어야 스프링 컨트롤러로 인식
public interface OrderControllerV1 {

    @GetMapping("/v1/request")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/v1/no-log")
    String nolog();

}
