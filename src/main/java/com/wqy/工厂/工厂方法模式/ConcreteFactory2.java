package com.wqy.工厂.工厂方法模式;

public class ConcreteFactory2 implements Factory {
    @Override
    public ConcreteProduct2 newProduct() {
        System.out.println("ConcreteFactory2工厂创建了ConcreteProduct2产品");
        return new ConcreteProduct2();
    }
}
