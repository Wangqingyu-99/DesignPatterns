package com.wqy.单例;

public class Test {
    public static void main(String[] args) {
        int i=0;
        while (i<500){
            i++;
            new Thread(()->{
//                System.out.println(  LazySingle.getInstance());
                System.out.println(  HungarySingle.getInstance());
            }).start();
        }
    }
}
