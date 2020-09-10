package com.wqy.工厂.抽象工厂模式;

public class WywFarm implements Farm {
    @Override
    public Animal newAnimal() {
        return new Sheep();
    }

    @Override
    public Plant newPlant() {
        return new Fruit();
    }
}
