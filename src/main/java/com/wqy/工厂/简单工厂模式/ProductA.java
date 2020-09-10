package com.wqy.工厂.简单工厂模式;

public class ProductA extends Product {
    @Override
    void methodA() {
        System.out.println("产品A的A方法");
    }

    @Override
    void methodB() {
        System.out.println("产品A的B方法");
    }
}
