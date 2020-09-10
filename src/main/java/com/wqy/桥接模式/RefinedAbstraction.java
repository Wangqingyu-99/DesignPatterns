package com.wqy.桥接模式;
//扩展抽象化角色
public class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor implementor){
        super(implementor);
    }
    @Override
    public void Operation() {
        System.out.println("扩展抽象化角色 方法被调用..");
        implementor.operationImpl();
    }
}
