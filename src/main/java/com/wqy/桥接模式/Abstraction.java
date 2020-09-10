package com.wqy.桥接模式;

//抽象化角色
public abstract class Abstraction {
    protected Implementor implementor;

    public Abstraction(Implementor implementor){
        this.implementor=implementor;
    }

    public abstract void Operation();
}
