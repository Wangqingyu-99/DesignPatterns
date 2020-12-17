package com.wqy.锁;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 死锁： 线程之间互相等待
 */
public class DeadLockTest {
    String a = "123";
    String b = "456";

    public static void main(String[] args) {
        new DeadLockTest().deadlock();
    }

    /**
     * 死锁实例
     */
    public void deadlock() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            synchronized (this.a) {
                System.out.println(new Date() + Thread.currentThread().getName() + "锁住a");
                synchronized (this.b) {
                    System.out.println(new Date() + Thread.currentThread().getName() + "锁住b");
                    System.out.println(new Date() + Thread.currentThread().getName() + "释放b");
                }
                System.out.println(new Date() + Thread.currentThread().getName() + "释放a");
            }
        });

        executorService.execute(() -> {
            synchronized (this.b) {
                System.out.println(new Date() + Thread.currentThread().getName() + "锁住b");
                synchronized (this.a) {
                    System.out.println(new Date() + Thread.currentThread().getName() + "锁住a");
                    System.out.println(new Date() + Thread.currentThread().getName() + "释放a");
                }
                System.out.println(new Date() + Thread.currentThread().getName() + "释放b");
            }
        });
    }

}
