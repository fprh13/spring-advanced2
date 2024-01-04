package spring.advanced.proxystart.pureproxy.decorator;

import org.junit.jupiter.api.Test;
import spring.advanced.proxystart.pureproxy.decorator.code.Component;
import spring.advanced.proxystart.pureproxy.decorator.code.MessageDecorator;
import spring.advanced.proxystart.pureproxy.decorator.code.RealComponent;
import spring.advanced.proxystart.pureproxy.decorator.code.TimeDecorator;

public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }

    @Test
    void decorator1() {
        Component realComponent = new RealComponent();
        Component messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
        client.execute();
    }

    @Test
    void decorator2() {
        Component realComponent = new RealComponent();
        Component messageDecorator = new MessageDecorator(realComponent);
        Component timeDecorator = new TimeDecorator(messageDecorator);
        DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);
        client.execute();
    }
}
