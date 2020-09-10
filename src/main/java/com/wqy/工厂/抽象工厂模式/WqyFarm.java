package com.wqy.工厂.抽象工厂模式;

public class WqyFarm implements Farm {
    @Override
    public Animal newAnimal() {
        return new Pig();
    }

    @Override
    public Plant newPlant() {
        return new Vegetables();
    }
}
