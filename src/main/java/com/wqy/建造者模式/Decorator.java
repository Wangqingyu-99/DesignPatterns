package com.wqy.建造者模式;

/**
 * 抽象构建者
 */
public abstract class Decorator {
    Product product=new Product();

    public abstract void buildSofa();
    public abstract void buildTV();
    public abstract void buildTeaTable();

    public Product getResult(){
        return product;
    }

}
