package com.wqy.原型模式;

import lombok.Data;

@Data
public class Prototype implements Cloneable {
    private String name;
    public  Prototype(){}

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
