package com.wqy.建造者模式;

/**
 * 建造者模式构成要素： 具体产品，抽象建造者，
 * 具体建造者（继承抽象建造者），指挥者（传入具体建造者，获得具体产品对象）
 */
public class Test {
    public static void main(String[] args) {
        ProjectManager projectManager = new ProjectManager(new ConcreteDecorator1());
        Product decorate = projectManager.decorate();
        System.out.println(decorate);

        ProjectManager projectManager1 = new ProjectManager(new ConcreteDecorator2());
        Product decorate1 = projectManager1.decorate();
        System.out.println(decorate1);
    }
}
