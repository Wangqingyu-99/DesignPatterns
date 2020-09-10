package com.wqy.单例;

import java.lang.reflect.Constructor;

public class Test {
    public static void main(String[] args) throws Exception {
        int i=0;
        while (i<500){
            i++;
            new Thread(()->{
                System.out.println(  LazySingle.getInstance());
//                System.out.println(  HungarySingle.getInstance());
            }).start();
        }

        //反射攻击
//        Class<HungarySingle> aClass = HungarySingle.class;
        Class<LazySingle> aClass = LazySingle.class;
//        Constructor<HungarySingle> constructor = aClass.getDeclaredConstructor();
        Constructor<LazySingle> constructor = aClass.getDeclaredConstructor();
        constructor.setAccessible(true);
//        HungarySingle hungarySingle =constructor.newInstance();
        LazySingle lazySingle =constructor.newInstance();
//        System.out.println(hungarySingle+"*****************");
        System.out.println(lazySingle+"*****************");
    }
}
