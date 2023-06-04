package hello.proxy.pureproxy.decorator.code.useAbstract;

import hello.proxy.pureproxy.decorator.code.Component;

public abstract class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        return  component.operation();
    }
}
