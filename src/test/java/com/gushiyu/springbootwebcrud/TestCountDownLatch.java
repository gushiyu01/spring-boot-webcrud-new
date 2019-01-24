package com.gushiyu.springbootwebcrud;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

import com.gushiyu.springbootwebcrud.config.ApplicationStartupUtil;

public class TestCountDownLatch {

    @Test
    public void testCountDownLatch() {
        boolean result = false;
        try {
            result = ApplicationStartupUtil.checkExternalServices();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("External services validation completed !! Result was :: " + result);
    }

    @Test
    public void test2() {
        final CountDownLatch latch = new CountDownLatch(2);
        new Thread() {

            @Override
            public void run() {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕.");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread() {

            @Override
            public void run() {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            System.out.println("等待两个线程执行完毕");
            latch.await();
            System.out.println("两个线程执行完毕");
            System.out.println("开始执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
