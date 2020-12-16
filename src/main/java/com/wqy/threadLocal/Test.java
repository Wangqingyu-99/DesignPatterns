package com.wqy.threadLocal;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
    HashMap<String, Object> map = new HashMap<>();

    public static void main(String[] args) {
        Test test = new Test();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);
        for (int i = 0; i <100 ; i++) {
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    test.setThreadLocal();
                    test.getThreadLocal();
//                    test.setMap();
//                    test.getMap();
                }
            });
//            test.getMap();
            test.setThreadLocal();
            test.getThreadLocal();
        }
    }

    public void setThreadLocal() {
        stringThreadLocal.set(Thread.currentThread().getName());
    }

    public void getThreadLocal() {
        String s = stringThreadLocal.get();
        System.out.println(s);
    }

    public void setMap(){
        map.put("name",Thread.currentThread().getName());
    }

    public void getMap(){
        Object name = map.get("name");
        System.out.println(name);
    }
}
