package com.wqy.工厂.抽象工厂模式;

public class Fruit implements Plant {
    @Override
    public void show() {
        System.out.println("水果成熟了！");
    }
}
