package com.wqy.建造者模式;

/**
 * 具体构建者1
 */
public class ConcreteDecorator1 extends Decorator {
    @Override
    public void buildSofa() {
        product.setSofa("真皮沙发");
    }

    @Override
    public void buildTV() {
        product.setTV("小米电视");
    }

    @Override
    public void buildTeaTable() {
       product.setTeaTable("玻璃茶几");
    }
}
