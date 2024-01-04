package spring.advanced.proxystart.pureproxy.concreteproxy;

import org.junit.jupiter.api.Test;
import org.springframework.aop.scope.ScopedProxyUtils;
import spring.advanced.proxystart.pureproxy.concreteproxy.code.ConcreteClient;
import spring.advanced.proxystart.pureproxy.concreteproxy.code.ConcreteLogic;
import spring.advanced.proxystart.pureproxy.concreteproxy.code.TimeProxy;

import java.sql.SQLOutput;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();
    }

    @Test
    void addProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient client = new ConcreteClient(timeProxy);
        client.execute();
    }
}
