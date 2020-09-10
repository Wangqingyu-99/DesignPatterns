package com.wqy.装饰者模式;

/**
 *
 * 具体装饰者
 */
public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addFunction();
    }

    public void addFunction(){
        System.out.println("装饰者增强.........");
    }
}
