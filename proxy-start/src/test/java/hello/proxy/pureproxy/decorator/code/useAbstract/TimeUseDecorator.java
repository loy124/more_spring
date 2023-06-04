package hello.proxy.pureproxy.decorator.code.useAbstract;

import hello.proxy.pureproxy.decorator.code.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeUseDecorator extends Decorator {


    public TimeUseDecorator(Component component) {
        super(component);
    }

    @Override
    public String operation() {
        log.info("TimeDecorator 실행");
        long startTime = System.currentTimeMillis();

        String result = super.operation();

        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;

        log.info("TimeDecorator 종료 resultTime={}ms",resultTime);

        return result;
    }
}
