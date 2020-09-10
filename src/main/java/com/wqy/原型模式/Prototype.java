package com.wqy.原型模式;

import lombok.Data;

/**
 * 实现Cloneable，实现clone方法
 */
@Data
public class Prototype implements Cloneable {
    private String name;
    public  Prototype(){}

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
