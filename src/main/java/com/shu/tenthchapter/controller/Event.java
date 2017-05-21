package com.shu.tenthchapter.controller;

/**
 * 定义事件抽象类
 * The common methods for any control event.
 * Created by Administrator on 2017-05-21.
 */
public abstract class Event {
    protected final long delayTime;
    private long startTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    //Allows restarting
    protected void start() {
        startTime = System.currentTimeMillis() + delayTime;
    }

    protected boolean isReady() {
        return System.currentTimeMillis() >= startTime;
    }

    public abstract void action();
}
