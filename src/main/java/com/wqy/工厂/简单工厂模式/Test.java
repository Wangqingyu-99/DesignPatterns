package com.wqy.工厂.简单工厂模式;

public class Test {
    public static void main(String[] args) {
        Product product1 = Factory.getProduct("A");
        product1.methodA();
        product1.methodB();

        Product product2 = Factory.getProduct("B");
        product2.methodA();
        product2.methodB();

        Product product = Factory.getProduct("");
    }
}
