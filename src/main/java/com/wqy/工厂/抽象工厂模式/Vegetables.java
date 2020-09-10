package com.wqy.工厂.抽象工厂模式;

public class Vegetables implements Plant {
    @Override
    public void show() {
        System.out.println("蔬菜成熟了！");
    }
}
