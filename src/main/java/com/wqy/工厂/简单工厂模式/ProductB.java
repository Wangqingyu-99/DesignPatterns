package com.wqy.工厂.简单工厂模式;

public class ProductB extends Product {
    @Override
    void methodA() {
        System.out.println("产品B的A方法");
    }

    @Override
    void methodB() {
        System.out.println("产品B的B方法");
    }
}
