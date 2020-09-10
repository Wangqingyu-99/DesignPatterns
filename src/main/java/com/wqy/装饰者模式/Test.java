package com.wqy.装饰者模式;

/**
 * 装饰模式主要包含以下角色。
 * 抽象构件（Component）角色：定义一个抽象接口以规范准备接收附加责任的对象。
 * 具体构件（Concrete    Component）角色：实现抽象构件，通过装饰角色为其添加一些职责。
 * 抽象装饰（Decorator）角色：继承抽象构件，并包含具体构件的实例，可以通过其子类扩展具体构件的功能。
 * 具体装饰（ConcreteDecorator）角色：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。
 *
 * 区别：
 * 1. 装饰器模式关注于在一个对象上动态的添加方法，然而代理模式关注于控制对对象的访问。
 * 2. 有的代理模式的被代理对象可以在编译时确定下来，而装饰者的被装饰类是在运行时动态设定的：
 */
public class Test {
    public static void main(String[] args) {
        ConcreteDecorator decorator = new ConcreteDecorator(new ConcreteComponent());
        decorator.operation();
    }
}
