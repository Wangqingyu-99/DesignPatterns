package com.wqy.线程.优雅的停止线程;

import lombok.SneakyThrows;

import java.util.Date;

public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        test2();
    }

    public static void test1() throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    System.out.println(Thread.currentThread().getName());
                    for (int i = 0; i < 90000; i++) {
                        int a = i;
                    }
                }
                System.out.println("线程中断++++++++++++++++++++++++++++++++");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(1000); //等线程先跑一秒 在修改中断状态
        thread.interrupt();
    }

    public static void test2() throws InterruptedException {
        Runnable runnable = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1);
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
    }
}
