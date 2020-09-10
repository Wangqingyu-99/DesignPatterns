package com.wqy.单例;

public class HungarySingle {
    private static HungarySingle single=new HungarySingle();
    private HungarySingle(){}
    public static HungarySingle getInstance(){
        return single;
    }
}
