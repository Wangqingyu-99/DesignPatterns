package com.wqy.工厂.工厂方法模式;

public class ConcreteFactory1 implements Factory {
    @Override
    public ConcreteProduct1 newProduct() {
        System.out.println("ConcreteFactory1工厂创建了ConcreteProduct1产品");
        return new ConcreteProduct1();
    }
}
