package hello.proxy.pureproxy.decorator;


import hello.proxy.pureproxy.decorator.code.*;
import hello.proxy.pureproxy.decorator.code.useAbstract.MessageUseDecorator;
import hello.proxy.pureproxy.decorator.code.useAbstract.TimeUseDecorator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

    @Test
    public void noDecorator(){
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();

    }

    @Test
    public void decorator1(){
        Component realComponent = new RealComponent();
        Component messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
        client.execute();;
    }

    @Test
    public void decorator2(){
        Component realComponent = new RealComponent();
        Component timeDecorator = new TimeDecorator(realComponent);
        Component messageDecorator = new MessageDecorator(timeDecorator);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
        client.execute();
    }

    @Test
    public void decorator3(){
        Component realComponent = new RealComponent();
        TimeUseDecorator timeUseDecorator = new TimeUseDecorator(realComponent);

        MessageUseDecorator messageUseDecorator = new MessageUseDecorator(timeUseDecorator);

        DecoratorPatternClient client = new DecoratorPatternClient(messageUseDecorator);
        client.execute();


    }



}
