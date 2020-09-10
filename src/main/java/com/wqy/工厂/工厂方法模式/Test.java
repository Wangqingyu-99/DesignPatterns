package com.wqy.工厂.工厂方法模式;

public class Test {
    public static void main(String[] args) {
        ConcreteFactory1 concreteFactory1 = new ConcreteFactory1();
        ConcreteProduct1 concreteProduct1 = concreteFactory1.newProduct();
        concreteProduct1.show();

        ConcreteFactory2 concreteFactory2 = new ConcreteFactory2();
        ConcreteProduct2 concreteProduct2 = concreteFactory2.newProduct();
        concreteProduct2.show();
    }
}
