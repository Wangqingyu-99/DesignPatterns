package com.wqy.装饰者模式;

/**
 * 抽象装饰
 */
public class Decorator implements Component {
    private Component component;
    public Decorator(Component component){
        this.component=component;
    }
    @Override
    public void operation() {
        component.operation();
    }
}
