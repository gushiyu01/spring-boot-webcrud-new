package com.gushiyu.springbootwebcrud.service;

import com.gushiyu.springbootwebcrud.entities.Message;

import java.util.concurrent.DelayQueue;

public class Consumer implements Runnable{

    //延时队列，消费者从其中获取消息进行消费
    private DelayQueue<Message> dq;

    public Consumer(DelayQueue<Message> dq) {
        this.dq = dq;
    }

    @Override
    public void run() {
        while (true){
            try {
                Message take = dq.take();
                System.out.println("Id:"+take.getId()+"\n"+"Body:"+take.getBody());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
