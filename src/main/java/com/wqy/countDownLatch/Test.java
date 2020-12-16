package com.wqy.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("主线程"+Thread.currentThread().getName()+"等待子线程执行完成...");
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i <10; i++) {
            Runnable runnable = new Runnable(){
                @Override
                public void run() {
                    System.out.println("当前线程："+Thread.currentThread().getName()+" 执行完毕！");
                    countDownLatch.countDown();
                }
            };
            executorService.execute(runnable);
        }
        countDownLatch.await();
        System.out.println("主线程执行完毕！");
    }
}
