package com.wqy.工厂.抽象工厂模式;

/**
 * 一个工厂可以生产多个同级的产品（产品族）
 */
public class Test {
    public static void main(String[] args) {
        WqyFarm wqyFarm = new WqyFarm();
        Animal animal = wqyFarm.newAnimal();
        animal.show();
        Plant plant = wqyFarm.newPlant();
        plant.show();

        WywFarm wywFarm = new WywFarm();
        Animal animal1 = wywFarm.newAnimal();
        Plant plant1 = wywFarm.newPlant();
        animal1.show();
        plant1.show();
    }
}
