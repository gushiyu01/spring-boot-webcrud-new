package com.gushiyu.springbootwebcrud;

import com.gushiyu.springbootwebcrud.entities.Message;
import com.gushiyu.springbootwebcrud.service.Consumer;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMain {
    /*public static void main(String[] args) {
        Long startTime = System.nanoTime();//1秒=1,000,000,000 纳秒(ns) 1纳秒=1／1,000,000,000秒(s)
        System.out.println(System.currentTimeMillis());//1秒=1000毫秒(ms) 1毫秒=1／1,000秒(s)
        Thread t = Thread.currentThread();
        try {
            t.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(System.nanoTime() - startTime);

    }*/

    public static void main(String[] args) {
        DelayQueue<Message> dq = new DelayQueue<>();
        //添加延时消息m1
        Message m1 = new Message(1,"hello",3000l);
        Message m2 = new Message(2,"world",10000l);
        //将延时消息放置延时队列中
        dq.offer(m1);


        System.out.println("测试冲突");
        System.out.println("gushiyu");
        dq.offer(m2);
        //启动消费线程，消费添加到延时队列的延时消息，前提是任务到了延时时间
        ExecutorService es = Executors.newFixedThreadPool(1);
        es.execute(new Consumer(dq));
        es.shutdown();
        System.out.println("测试冲突");
        System.out.println("怎么才有冲突");

        System.out.println(
                "123"
        );
    }

}
