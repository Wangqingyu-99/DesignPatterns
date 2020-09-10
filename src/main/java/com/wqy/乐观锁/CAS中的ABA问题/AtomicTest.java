package com.wqy.乐观锁.CAS中的ABA问题;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicTest {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger i = new AtomicInteger(0);
        new Thread(()->{
            i.compareAndSet(0,1);
            i.compareAndSet(1,0);
            System.out.println(Thread.currentThread().getName());
        },"A线程").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i.compareAndSet(0,6);

        },"B线程").start();

        Thread.sleep(3000);
        System.out.println(i);
    }
}
