package com.wqy.乐观锁.CAS中的ABA问题;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * AtomicStampedReference 相当于增加了一个版本号来记录有没有出现ABA问题
 */
public class AtomicStampedReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        AtomicStampedReference stampedReference = new AtomicStampedReference(0, 0);
        int firstStamp = stampedReference.getStamp();

        new Thread(()->{
            stampedReference.compareAndSet(0, 1,
                    stampedReference.getStamp(), stampedReference.getStamp() + 1);

            stampedReference.compareAndSet(1, 0,
                    stampedReference.getStamp(), stampedReference.getStamp() + 1);
        },"线程A").start();

        new Thread(()->{
            stampedReference.compareAndSet(0,666,
                    firstStamp, stampedReference.getStamp() + 1);
        },"线程B").start();

        Thread.sleep(3000);
        System.out.println(stampedReference.getStamp());
        System.out.println(stampedReference.getReference());
    }
}
