package com.wqy.建造者模式;

/**
 * 具体构建者1
 */
public class ConcreteDecorator2 extends Decorator {
    @Override
    public void buildSofa() {
        product.setSofa("翻毛沙发");
    }

    @Override
    public void buildTV() {
        product.setTV("创维电视");
    }

    @Override
    public void buildTeaTable() {
       product.setTeaTable("红木茶几");
    }
}
