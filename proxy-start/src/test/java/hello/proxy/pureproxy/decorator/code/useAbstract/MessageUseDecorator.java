package hello.proxy.pureproxy.decorator.code.useAbstract;

import hello.proxy.pureproxy.decorator.code.Component;
import hello.proxy.pureproxy.decorator.code.useAbstract.Decorator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageUseDecorator extends Decorator {

    public MessageUseDecorator(Component component) {
        super(component);
    }

    @Override
    public String operation() {
        log.info("MessageDecorator 실행");

        String result = super.operation();

        String decoResult = "****" + result + "****";
        log.info("MessageDecorator 꾸미기 적용 전={}, 적용 후={}", result, decoResult);


        return decoResult;
    }


}
