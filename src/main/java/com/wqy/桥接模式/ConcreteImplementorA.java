package com.wqy.桥接模式;
//具体实现化角色
public class ConcreteImplementorA implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("具体实现化 operationImpl（）方法执行了......");
    }
}
