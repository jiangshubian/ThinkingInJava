package com.shu.twentyfirstchapter.concurrency.caughtException;

import javax.management.relation.RoleUnresolved;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Administrator on 2017/12/2.
 */
public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}

class ExceptionThread2 implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException("主动抛出异常！");
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("eh = "+t.getUncaughtExceptionHandler()+",Caught: " + e);
    }
}

class HandlerThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this +" creating new Thread.");
        Thread t = new Thread(r);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = "+t.getUncaughtExceptionHandler());
        return t;
    }
}