package com.wqy.装饰者模式;

/**
 * 具体构建
 */
public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("具体构建的方法执行，，，，，，，，，，");
    }
}
