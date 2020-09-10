package com.wqy.原型模式;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new Prototype();
        prototype.setName("tz");

        Prototype clone =(Prototype) prototype.clone();

        System.out.println(clone);
    }
}
