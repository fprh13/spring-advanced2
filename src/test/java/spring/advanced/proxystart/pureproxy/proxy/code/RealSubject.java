package spring.advanced.proxystart.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

/**
 * 얘) 데이터를 데이터베이스나 외부에서 조회하는데 1초가 걸린다고 생각하자
 * 호출할 때 마다 시스템에 큰 부하를 주는 데이터 조회라고 가정
 */
@Slf4j
public class RealSubject implements Subject{
    @Override
    public String operation() {
        log.info("실제 객체 호출");
        sleep(1000);
        return "data";
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
