package com.wqy.工厂.简单工厂模式;

public class Factory {
    private static Product product=null;
    public static Product getProduct(String str){
        if (("A").equals(str)){
            product=new ProductA();
        }else if ("B".equals(str)){
            product=new ProductB();
        }else {
            System.out.println("没有该产品！");
            throw new RuntimeException();
        }
        return product;
    }
}
