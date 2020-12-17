package com.wqy.锁;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    static int a = 0;

    public static void main(String[] args) throws InterruptedException {
        lockTest1();
    }

    public static void lockTest1() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        ReentrantLock lock = new ReentrantLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    lock.lock();
                    a++;
                    lock.unlock();
                }
                countDownLatch.countDown();
            }
        };
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        fixedThreadPool.execute(runnable);
        fixedThreadPool.execute(runnable);
//        Thread.sleep(3000);
        countDownLatch.await();
        System.out.println(a);
    }
}
