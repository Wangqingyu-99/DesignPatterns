package com.wqy.建造者模式;

/**
 * 指挥者
 */
public class ProjectManager {
    private Decorator builder;

    public ProjectManager(Decorator builder){
        this.builder=builder;
    }

//    产品构建与组装方法
    public Product decorate(){
        builder.buildSofa();
        builder.buildTV();
        builder.buildTeaTable();
        return builder.getResult();
    }
}
