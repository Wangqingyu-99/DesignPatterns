package com.wqy.代理模式;

/**
 * 真实主题 眉山特产
 */
public class MsSpecialty implements Specialty {

    @Override
    public void display() {
        System.out.println("眉山的特产有榨菜，椪柑，东坡肘子...");
    }
}
