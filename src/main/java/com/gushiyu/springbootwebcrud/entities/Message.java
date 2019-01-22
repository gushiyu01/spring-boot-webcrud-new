package com.gushiyu.springbootwebcrud.entities;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Message implements Delayed {
    private int id;
    private String body;
    private Long executeTime;//延时时长，这个是必须属性，因为要按照这个判断延时时长

    public Message(int id, String body, Long delayTime) {
        this.id = id;
        this.body = body;
        this.executeTime = TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) + System.nanoTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Long executeTime) {
        this.executeTime = executeTime;
    }

    //延迟任务是否到时就是按照这个方法判断，如果返回的是负数则说明还没到期
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.executeTime-System.nanoTime(),TimeUnit.NANOSECONDS);
    }

    @Override
    //自定义比较方法返回1 -1 0 三个参数
    public int compareTo(Delayed o) {
        Message msg = (Message) o;
        return Integer.valueOf(this.id) > Integer.valueOf(msg.id) ? 1 : (Integer.valueOf(this.id) < Integer.valueOf(msg.id) ? -1 : 0);
    }
}
